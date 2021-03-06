/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerinax.azurefunctions.handlers.http;

import org.ballerinax.azurefunctions.AzureFunctionsException;
import org.ballerinax.azurefunctions.BindingType;
import org.ballerinax.azurefunctions.Utils;
import org.ballerinax.azurefunctions.handlers.AbstractParameterHandler;
import org.wso2.ballerinalang.compiler.semantics.model.symbols.BVarSymbol;
import org.wso2.ballerinalang.compiler.tree.BLangAnnotationAttachment;
import org.wso2.ballerinalang.compiler.tree.BLangSimpleVariable;
import org.wso2.ballerinalang.compiler.tree.expressions.BLangExpression;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation for the output parameter handler annotation "@HTTPOutput".
 */
public class HTTPOutputParameterHandler extends AbstractParameterHandler {

    private BVarSymbol var;

    public HTTPOutputParameterHandler(BLangSimpleVariable param, BLangAnnotationAttachment annotation) {
        super(param, annotation, BindingType.OUTPUT);
    }

    @Override
    public BLangExpression invocationProcess() throws AzureFunctionsException {
        if (!Utils.isAzurePkgType(ctx, "HTTPBinding", this.param.type)) {
            throw this.createError("Type must be 'HTTPBinding'");
        }
        this.var = Utils.addAzurePkgRecordVarDef(this.ctx, "HTTPBinding", this.ctx.getNextVarName());
        return Utils.createVariableRef(this.ctx.globalCtx, this.var);
    }

    @Override
    public void postInvocationProcess() throws AzureFunctionsException {
        if (Utils.isPureHTTPBinding(this.ctx)) {
            Utils.addAzurePkgFunctionCall(this.ctx, "setPureHTTPOutput", true,
                    Utils.createVariableRef(ctx.globalCtx, ctx.handlerParams),
                    Utils.createVariableRef(this.ctx.globalCtx, this.var));
        } else {
            Utils.addAzurePkgFunctionCall(this.ctx, "setHTTPOutput", true,
                    Utils.createVariableRef(ctx.globalCtx, ctx.handlerParams),
                    Utils.createStringLiteral(this.ctx.globalCtx, this.name),
                    Utils.createVariableRef(this.ctx.globalCtx, this.var));
        }
    }

    @Override
    public Map<String, Object> generateBinding() {
        Map<String, Object> binding = new LinkedHashMap<>();
        binding.put("type", "http");
        return binding;
    }
    
}
