package com.tenstech.todocore.task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<TaskDTO> getAll();

    Optional<TaskDTO> getById(Long id);

    Optional<TaskDTO> createTask(TaskDTO taskDTO);

    Optional<TaskDTO> updateTask(TaskDTO taskDTO);
}
