package com.demo.tasktracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.tasktracker.dto.CreateTaskDTO;
import com.demo.tasktracker.dto.TaskDTO;
import com.demo.tasktracker.entity.Task;
import com.demo.tasktracker.exception.TaskNotFoundException;
import com.demo.tasktracker.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void createTask_shouldSaveEntityAndReturnDto(){
        CreateTaskDTO request = new CreateTaskDTO("Study tests", "Monday");

        Task savedTask = new Task();
        savedTask.setTaskId(1);
        savedTask.setTaskText("Study tests");
        savedTask.setTaskDay("Monday");
        savedTask.setTaskReminder(false);

        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        TaskDTO result = taskService.createTask(request);

        assertEquals(1,result.id());
        assertEquals("Study tests",result.text());
        assertEquals("Monday", result.day());
        assertFalse(result.reminder());
        
        verify(taskRepository).save(any(Task.class));

    }

    @Test
    void getAllTasks_shouldReturnDtoList(){
        Task task1 = new Task();
        task1.setTaskId(1);
        task1.setTaskText("Study");
        task1.setTaskDay("Monday");
        task1.setTaskReminder(false);

        Task task2 = new Task();
        task2.setTaskId(2);
        task2.setTaskText("Work");
        task2.setTaskDay("Wednesday");
        task2.setTaskReminder(false);
        
        when(taskRepository.findAll())
            .thenReturn(List.of(task1,task2));

        List<TaskDTO> result = taskService.getAllTasks();

        assertNotNull(result);
        assertEquals(2, result.size() );
        TaskDTO firstTask = result.getFirst();
        TaskDTO lastTask  = result.getLast();
        assertEquals(1, firstTask.id());
        assertEquals("Study", firstTask.text());
        assertEquals(false, lastTask.reminder());
    }

    @Test
    void getTaskById_whenExists_shouldReturnDto(){
        Task task = new Task();
        task.setTaskId(1);
        task.setTaskText("Study");
        task.setTaskDay("Monday");
        task.setTaskReminder(false);

        when(taskRepository.findById(1))
            .thenReturn(Optional.of(task));

        TaskDTO result = taskService.getTaskById(1);
        assertEquals(1, result.id());
        assertEquals("Study", result.text());

    }

    @Test
    void getTaskById_whenNotFound_shouldThrowException(){
        when(taskRepository.findById(99))
            .thenReturn(Optional.empty());

        TaskNotFoundException exception = assertThrows(TaskNotFoundException.class, 
                () -> taskService.getTaskById(99));

        assertEquals("Task not found with id: 99", exception.getMessage());

    }


    @Test
    void deleteTask_whenExists_shouldDelete(){
        when(taskRepository.existsById(1))
            .thenReturn(true);

        taskService.deleteTask(1);
        verify(taskRepository).existsById(1);
        verify(taskRepository).deleteById(1);    
    }

    @Test
    void deleteTask_whenNotFound_shouldThrowException(){
        when(taskRepository.existsById(99)).thenReturn(false);

        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class
            ,()-> taskService.deleteTask(99));

        assertEquals("Task not found with id 99", exception.getMessage() );

        
        verify(taskRepository,never()).deleteById(99);
    }




}
