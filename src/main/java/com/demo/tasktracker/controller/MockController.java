package com.demo.tasktracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mock")
public class MockController {

    private static final Logger logger = LoggerFactory.getLogger(MockController.class);

    @GetMapping("/ping")
    public String ping(){
        logger.debug("Inside ping");
        logger.debug("more ping");
        return "ping";
    }

    @GetMapping("/pong")
    public ResponseEntity<String> pong() {
        logger.debug("Inside pong");
        logger.debug("more logs for pong");
        logger.debug("more logs 1 for pong");
        logger.debug("more logs 2 for pong");
        logger.debug("more logs 3 for pong");     
        logger.debug("more logs 4 for pong"); 
        logger.debug("more logs 5 for pong");
        return ResponseEntity.ok("pong");
    }

}
