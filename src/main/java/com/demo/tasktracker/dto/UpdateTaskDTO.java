package com.demo.tasktracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateTaskDTO(
    @NotBlank(message = "text is required for update an existing Task")
    @Size(max = 255, message = "text must not exceed 255 characters")
    String text,

    @NotBlank(message = "day is required for update an existing task")
    @Size(max = 100, message = "day must not excee 100 characters")
    String day,

    @NotBlank(message = "a value must be set for reminder")
    Boolean reminder
) {
}
