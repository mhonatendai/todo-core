package com.tenstech.todocore.typemapper;


import com.tenstech.todocore.model.Task;
import com.tenstech.todocore.task.TaskDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TypeMapper {

    Task toTask(TaskDTO taskDTO);

    TaskDTO toTaskDTO(Task task);

}