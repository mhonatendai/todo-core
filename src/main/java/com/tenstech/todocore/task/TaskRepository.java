package com.tenstech.todocore.task;

import com.tenstech.todocore.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
