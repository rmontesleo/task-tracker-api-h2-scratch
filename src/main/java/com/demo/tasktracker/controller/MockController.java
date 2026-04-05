package com.demo.tasktracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mock")
public class MockController {

    @GetMapping("/ping")
    public String ping(){
        return "ping";
    }

    @GetMapping("/pong")
    public ResponseEntity<String> pong() {
        return ResponseEntity.ok("pong");
    }

}
