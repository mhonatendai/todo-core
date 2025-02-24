package com.tenstech.todocore.task;

import com.tenstech.todocore.model.Task;
import com.tenstech.todocore.typemapper.TypeMapper;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final TypeMapper typeMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TypeMapper typeMapper) {
        this.taskRepository = taskRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public List<TaskDTO> getAll() {
        return this.typeMapper.getTaskDTOs(taskRepository.findAll());
    }

    @Override
    public Optional<TaskDTO> getById(Long id) {
        return taskRepository.findById(id).map(typeMapper::toTaskDTO);
    }

    @Override
    public Optional<TaskDTO> createTask(TaskDTO taskDTO) {
        return Optional.of(typeMapper.toTaskDTO(taskRepository.save(typeMapper.toTask(taskDTO))));
    }

    @Override
    public Optional<TaskDTO> updateTask(TaskDTO taskDTO) {
        return taskRepository.findById(taskDTO.getId())
                .map(existingTask -> {
                    typeMapper.updateTaskFromDTO(taskDTO, existingTask);
                    Task updatedTask = taskRepository.save(existingTask);
                    return typeMapper.toTaskDTO(updatedTask);
                });
    }
}
