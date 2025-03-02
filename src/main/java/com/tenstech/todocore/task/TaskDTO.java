package com.tenstech.todocore.task;

import com.tenstech.todocore.common.TaskStatus;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO{

    private Long id;

    private String title;

    private String description;

    private TaskStatus taskStatus;

    private LocalDateTime dueDate;

    private LocalDateTime closedDate;

    private String closingRemark;
}
