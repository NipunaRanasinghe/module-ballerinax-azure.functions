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
package org.ballerinax.azurefunctions;

 /**
 * Constants for Azure Functions.
 */
public class Constants {
    
    public static final String AZURE_FUNCS_REG_FUNCTION_NAME = "__register";
    public static final String MAIN_FUNC_NAME = "main";
    public static final String AZURE_FUNCTIONS_MODULE_NAME = "azure.functions";
    public static final String BALLERINA_ORG = "ballerina";
    public static final String HTTP_MODULE_NAME = "http";
    public static final String HTTP_REQUEST_NAME = "Request";
    public static final String HTTP_MODULE_VERSION = "0.0.0";
    public static final String REQUEST_PARAMS_TYPE = "HandlerParams";
    public static final String REQUEST_PARAMS_NAME = "params";
    public static final String AZURE_FUNCTIONS_PACKAGE_ORG = "ballerinax"; 
    public static final String AZURE_FUNCTIONS_CONTEXT_NAME = "Context";
    public static final String AZURE_FUNCS_OUTPUT_ZIP_FILENAME = "azure-functions.zip";
    public static final String GEN_FUNC_SUFFIX = "0dadec8e-7c9c-44c3-88ea-f947acc3add7";
    public static final String DUMMY_SERVICE_NAME = "249b70ab-c5b5-4758-9d50-193f9dbb6eb6";
    public static final String FUNCTION_BINDINGS_NAME = "bindings";
    public static final String CHARSET = "UTF-8";
    public static final String DEFAULT_STORAGE_CONNECTION_NAME = "AzureWebJobsStorage";
    public static final String DEFAULT_TWILIO_ACCOUNT_SID_SETTING = "AzureWebJobsTwilioAccountSid";
    public static final String DEFAULT_TWILIO_AUTH_TOKEN_SETTING = "AzureWebJobsTwilioAuthToken";
    public static final boolean DEFAULT_TIMER_TRIGGER_RUNONSTARTUP = true;
    public static final boolean DEFAULT_COSMOS_DB_CREATELEASECOLLECTIONIFNOTEXISTS = true;

}
