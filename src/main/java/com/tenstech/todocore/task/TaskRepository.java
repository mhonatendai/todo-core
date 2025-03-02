package com.tenstech.todocore.task;

import com.tenstech.todocore.common.TaskStatus;
import com.tenstech.todocore.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    List<Task> findAllByDueDate(LocalDateTime dueDate);
}
