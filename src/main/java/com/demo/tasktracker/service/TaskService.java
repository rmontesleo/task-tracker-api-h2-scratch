package com.demo.tasktracker.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.tasktracker.dto.CreateTaskDTO;
import com.demo.tasktracker.dto.TaskDTO;
import com.demo.tasktracker.dto.UpdateTaskDTO;
import com.demo.tasktracker.entity.Task;
import com.demo.tasktracker.exception.TaskNotFoundException;
import com.demo.tasktracker.mapper.TaskMapper;
import com.demo.tasktracker.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public TaskDTO createTask(CreateTaskDTO createTaskDTO){
        Task entityToSave = TaskMapper.toEntity(createTaskDTO);
        Task savedEntity = taskRepository.save(entityToSave);
        return TaskMapper.toDTO(savedEntity);
    }

    public List<TaskDTO> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        return TaskMapper.toDTOList(tasks);
    }

    private Task findTaskById(Integer id ){
        return taskRepository.findById(id)
            .orElseThrow( ()-> new TaskNotFoundException(id) );
    }

    public TaskDTO getTaskById(Integer id){
        Task task = findTaskById(id);
        return TaskMapper.toDTO(task);
    }

    public TaskDTO updateTask(Integer id, UpdateTaskDTO taskDTO){
        Task task =  findTaskById(id);
        task.setTaskDay(taskDTO.text());
        task.setTaskDay(taskDTO.day());
        task.setTaskReminder(taskDTO.reminder());
        Task updatedTask = taskRepository.save(task);
        return TaskMapper.toDTO(updatedTask);
    }

    public void deleteTask(Integer id){
        if (!taskRepository.existsById(id)){
            throw new IllegalArgumentException("Task not found with id" + id);
        }
        taskRepository.deleteById(id);
    }




}
