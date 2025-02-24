package com.tenstech.todocore.typemapper;


import com.tenstech.todocore.model.Task;
import com.tenstech.todocore.task.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TypeMapper {

    Task toTask(TaskDTO taskDTO);

    TaskDTO toTaskDTO(Task task);

    List<TaskDTO> getTaskDTOs(List<Task> tasks);

    void updateTaskFromDTO(TaskDTO taskDTO, @MappingTarget Task task); // No need to ignore updatedAt

}