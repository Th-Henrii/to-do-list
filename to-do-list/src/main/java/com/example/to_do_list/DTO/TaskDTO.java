package com.example.to_do_list.DTO;


import com.example.to_do_list.entities.Task;
import jakarta.persistence.*;


public class TaskDTO {


    private Long taskId;

    private String title;
    private String description;
    private boolean status;

    public TaskDTO(){

    }

    public TaskDTO(Task entity) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void markAsCompleted() {
        this.status = true;
    }
}
