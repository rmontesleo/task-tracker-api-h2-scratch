package com.demo.tasktracker.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Integer id){
        super("Task not found with id: "+ id);
    }
}
