package com.example.to_do_list.DTO;

import com.example.to_do_list.entities.TaskCategory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

public class TaskCategoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public TaskCategoryDTO(){

    }

    public TaskCategoryDTO(TaskCategory entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
