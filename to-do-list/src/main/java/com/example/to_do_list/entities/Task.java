package com.example.to_do_list.entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(columnDefinition = "TEXT")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private boolean status;

    public Task(){

    }

    public Task(Long taskId, String title, String description, boolean status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void markAsCompleted() {
        this.status = true;
    }
}
