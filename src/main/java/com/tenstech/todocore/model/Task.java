package com.tenstech.todocore.model;

import com.tenstech.todocore.common.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Task extends AuditedEntity{

    @Column
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Column
    private LocalDateTime dueDate;

    @Column
    private LocalDateTime closedDate;

    @Column
    private String closingRemark;
}
