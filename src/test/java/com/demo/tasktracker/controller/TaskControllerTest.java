package com.demo.tasktracker.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.tasktracker.dto.CreateTaskDTO;
import com.demo.tasktracker.dto.TaskDTO;
import com.demo.tasktracker.dto.UpdateTaskDTO;
import com.demo.tasktracker.exception.TaskNotFoundException;
import com.demo.tasktracker.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(TaskController.class)
public class TaskControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private TaskService taskService;

    @Test
    void getAllTasks_shouldReturnTask() throws Exception {
        List<TaskDTO> tasks = List.of(
            new TaskDTO(1, "Study Spring Boot", "Monday", false ),
            new TaskDTO(2, "Write tests", "Tuesday", true )
        );

        Mockito.when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks"))
                    .andExpect(status().isOk() )
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].id").value(1) )
                    .andExpect(jsonPath("$[0].text").value("Study Spring Boot") );

    }

    @Test
    void createTask_shoudReturnCreatedTask() throws Exception {
        CreateTaskDTO request = new CreateTaskDTO("Study testing", "Friday");
        TaskDTO response = new TaskDTO(1, "Study testing", "Friday", false);

        Mockito.when(taskService.createTask(any(CreateTaskDTO.class))).thenReturn(response);

        mockMvc.perform(post("/api/tasks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.text").value("Study testing"))
                .andExpect(jsonPath("$.reminder" ).value(false));
    }

    @Test
    void getTaskById_whenNotFound_shouldReturn404() throws Exception {
        Mockito.when(taskService.getTaskById(99))
            .thenThrow(new TaskNotFoundException(99));

        mockMvc.perform(get("/api/tasks/{id}", 99))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.status").value(404))
            .andExpect(jsonPath("$.message").value("Task not found with id: 99"));
    }

    @Test
    void createTask_whenInvalidRequest_shouldReturn400() throws Exception{
        String invalidJson = """
                {
                    "text": "",
                    "day":  ""
                }
                """;

        mockMvc.perform(post("/api/tasks")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(invalidJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400));
    }

    @Test
    void updateTask_shouldReturnUpdatedTask() throws Exception{
        UpdateTaskDTO request = new UpdateTaskDTO("Updated Task", "Saturday", true);
        TaskDTO response = new TaskDTO(1, "Updated Task", "Saturday", true);

        Mockito.when(taskService.updateTask(eq(1),any(UpdateTaskDTO.class))).thenReturn(response);

        mockMvc.perform(put("/api/tasks/{id}",1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.text").value("Updated Task"))
                .andExpect(jsonPath("$.reminder").value(true));

    }

    @Test
    void deleteTask_shouldReturnNoContent() throws Exception{
        Mockito.doNothing().when(taskService).deleteTask(1);

        mockMvc.perform(delete("/api/tasks/{id}", 1))
                .andExpect(status().isNoContent());
        
        // Verify deleteTask was called exactly 1 time with argument 1
        Mockito.verify(taskService, Mockito.times(1)).deleteTask(1);
    }





}
