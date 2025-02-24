package com.tenstech.todocore.task;

import com.tenstech.todocore.common.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO{

    private String title;

    private String description;

    private TaskStatus taskStatus;
}
