package com.demo.tasktracker.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.demo.tasktracker.entity.Task;

@DataJpaTest
@ActiveProfiles("test")
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void save_shouldPersistTask(){
        Task task = new Task();
        task.setTaskText("Repository test");
        task.setTaskDay("Monday");
        task.setTaskReminder(false);

        Task saved = taskRepository.save(task);

        assertNotNull(saved.getTaskId());
        assertEquals("Repository test", saved.getTaskText());
    }

    @Test
    void findAll_shouldReturnSavedTasks(){
        Task task = new Task();
        task.setTaskText("Find all test");
        task.setTaskDay("Tuesday");
        task.setTaskReminder(true);
        
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty() );
        assertEquals(1, tasks.size());
    }

    @Test
    void findById_whenExists_shouldReturnTask(){
        Task task = new Task();
        task.setTaskText("Find by id test");
        task.setTaskDay("Wednesday");
        task.setTaskReminder(false);

        Task saved = taskRepository.save(task);
        Optional<Task> found = taskRepository.findById(saved.getTaskId());

        assertNotNull(found);
        assertTrue(found.isPresent());
        assertEquals("Find by id test", found.get().getTaskText() );

    }

    @Test
    void deleteById_shouldRemoveTask(){
        Task task = new Task();
        task.setTaskText("Delete test");
        task.setTaskDay("Thursday");
        task.setTaskReminder(false);

        Task saved = taskRepository.save(task);
        var id = saved.getTaskId();
        taskRepository.deleteById(id);

        Optional<Task> found = taskRepository.findById(id);
        assertTrue(found.isEmpty());
    }


}
