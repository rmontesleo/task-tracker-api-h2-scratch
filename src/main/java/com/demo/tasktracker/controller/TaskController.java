package com.demo.tasktracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.demo.tasktracker.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "ping";
    }

    @GetMapping("/pong")
    public ResponseEntity<String> pong() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        String body = taskService.sayHelloWorld();
        return ResponseEntity.ok(body);
    }
    
    


    public void postTask(){

    }

    public void getAllTasks(){

    }

    public void getTaskById(){

    }

    public void updateTask(){

    }

    public void deleteTask(){

    }



}
