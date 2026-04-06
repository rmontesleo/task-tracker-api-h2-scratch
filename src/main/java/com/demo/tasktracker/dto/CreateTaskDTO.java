package com.demo.tasktracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskDTO(

    @NotBlank(message = "text is required for create a new Task")
    @Size(max = 255, message = "text must not exceed 255 characters")
    String text,

    @NotBlank(message = "day is required for create a new Task")
    @Size(max = 100, message = "day must not exceed 100 characters")
    String day
){
}
