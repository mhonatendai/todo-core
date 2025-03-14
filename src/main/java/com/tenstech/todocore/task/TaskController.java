package com.tenstech.todocore.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        return taskService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOs = taskService.getAll();
        return ResponseEntity.ok(taskDTOs);
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        log.info("Creating task: {}",taskDTO);
        Optional<TaskDTO> createdTaskDTO = taskService.createTask(taskDTO);
        log.info("Created task: {}",createdTaskDTO.map(taskDTO1 -> toString()));
        return createdTaskDTO.map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {

        if (!taskDTO.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }

        Optional<TaskDTO> updatedTaskDTO = taskService.updateTask(taskDTO);
        return updatedTaskDTO.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}