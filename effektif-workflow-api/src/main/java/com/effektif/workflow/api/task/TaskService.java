/*
 * Copyright 2014 Effektif GmbH.
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
 * limitations under the License.
 */
package com.effektif.workflow.api.task;

import java.util.List;

import com.effektif.workflow.api.model.TaskId;
import com.effektif.workflow.api.model.UserId;


/**
 * @author Tom Baeyens
 */
public interface TaskService {

  Task createTask(Task task);

  Task assignTask(TaskId taskId, UserId assignee);

  Task findTaskById(TaskId taskId);
  List<Task> findTasks(TaskQuery taskQuery);
  
  void deleteTasks(TaskQuery taskQuery);

  Task completeTask(TaskId taskId);

}
