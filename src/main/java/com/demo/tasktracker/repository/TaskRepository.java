package com.demo.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.tasktracker.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
