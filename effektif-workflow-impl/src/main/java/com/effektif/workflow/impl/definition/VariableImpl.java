/* Copyright 2014 Effektif GmbH.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */
package com.effektif.workflow.impl.definition;

import com.effektif.workflow.api.workflow.Variable;
import com.effektif.workflow.impl.WorkflowEngineImpl;
import com.effektif.workflow.impl.plugin.Descriptors;
import com.effektif.workflow.impl.type.DataType;


public class VariableImpl {

  public String id;
  public DataType dataType;
  public Object initialValue;

  public WorkflowEngineImpl workflowEngine;
  public WorkflowImpl workflow;  
  public ScopeImpl parent;

  public void validate(Variable apiVariable, ScopeImpl parent, WorkflowValidator validator) {
    String id = apiVariable.getId();
    if (id!=null && !"".equals(id)) {
      this.id = id;
    } else {
      validator.addError("Variable has no id");
    }
    this.parent = parent;
    Descriptors descriptors = validator.workflowEngine.getServiceRegistry().getService(Descriptors.class);
    this.dataType = descriptors.instantiateDataType(apiVariable);
    this.dataType.validate(this, apiVariable, validator);
  }
}
