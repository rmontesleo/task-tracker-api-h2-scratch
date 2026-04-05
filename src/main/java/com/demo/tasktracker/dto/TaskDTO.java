package com.demo.tasktracker.dto;

public record TaskDTO(
    Integer id,
    String text,
    String day,
    Boolean reminder
) {

}
