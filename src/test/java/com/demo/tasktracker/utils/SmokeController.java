package com.demo.tasktracker.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.tasktracker.controller.TaskController;

@SpringBootTest
public class SmokeController {

    @Autowired
    private TaskController taskController;


    @Test
    void contextLoads() throws Exception{
        assertNotNull(taskController);
    }

}
