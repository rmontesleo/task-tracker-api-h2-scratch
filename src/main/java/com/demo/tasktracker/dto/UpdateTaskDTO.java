package com.demo.tasktracker.dto;

public record UpdateTaskDTO(
    String text,
    String day,
    Boolean reminder
) {

}
