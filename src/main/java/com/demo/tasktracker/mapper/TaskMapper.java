package com.demo.tasktracker.mapper;

import java.util.Collections;
import java.util.List;

import com.demo.tasktracker.dto.CreateTaskDTO;
import com.demo.tasktracker.dto.TaskDTO;
import com.demo.tasktracker.entity.Task;

public class TaskMapper {
    private static final Boolean DEFAULT_REMINDER = Boolean.FALSE;

    private TaskMapper(){}

    public static Task toEntity(CreateTaskDTO dto){
        if (dto == null) {
            return null;
        }
        Task task = new Task();
        task.setTaskText(dto.text());
        task.setTaskDay(dto.day());
        task.setTaskReminder(DEFAULT_REMINDER); //default value
        return task;
    }

    public static TaskDTO toDTO(Task entity){
        if (entity == null){
            return null;
        }
        return new TaskDTO(
            entity.getTaskId(),
            entity.getTaskText(),
            entity.getTaskDay(),
            entity.getTaskReminder()
        );
    }

    public static List<TaskDTO> toDTOList(List<Task> entities){
        if (entities == null){
            return Collections.emptyList();
        }
        return entities.stream()
                .map(TaskMapper::toDTO)
                .toList();
    }

}
