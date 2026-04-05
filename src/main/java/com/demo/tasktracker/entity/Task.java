package com.demo.tasktracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "task_id")
    private Integer taskId;

    @Column( name="task_text", nullable = false)
    private String taskText;

    @Column(name = "task_day", nullable = false)
    private String taskDay;

    @Column(name = "task_reminder", nullable = false)
    private Boolean taskReminder;

}
