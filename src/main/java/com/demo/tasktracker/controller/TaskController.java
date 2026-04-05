package com.demo.tasktracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.tasktracker.dto.CreateTaskDTO;
import com.demo.tasktracker.dto.TaskDTO;
import com.demo.tasktracker.dto.UpdateTaskDTO;
import com.demo.tasktracker.service.TaskService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    
    @PostMapping
    public ResponseEntity<TaskDTO> postTask(@RequestBody CreateTaskDTO newTaskDTO ) {
        TaskDTO createdTaskDTO = taskService.createTask(newTaskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskDTO);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok( taskService.getAllTasks() );
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer id) {
        logger.debug("Controller: Searching task with id={}", id);

        TaskDTO task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> putTask(@PathVariable Integer id, @RequestBody UpdateTaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(id,taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id ){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
