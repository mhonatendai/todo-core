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

    protected LocalDateTime created;

    protected LocalDateTime lastModified;

    protected String createdBy;

    protected String modifiedBy;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                ", dueDate=" + dueDate +
                ", closedDate=" + closedDate +
                ", closingRemark='" + closingRemark + '\'' +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
