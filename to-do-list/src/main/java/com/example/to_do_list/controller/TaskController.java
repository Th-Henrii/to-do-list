package com.example.to_do_list.controller;


import com.example.to_do_list.DTO.TaskDTO;
import com.example.to_do_list.entities.Task;
import com.example.to_do_list.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskServices taskServices;


    @GetMapping(value = "/{idTask}")
    public TaskDTO findTaskById(@PathVariable Long idTask){
        TaskDTO result = taskServices.findById(idTask);
        return result;
    }

    @GetMapping
    public List<TaskDTO> findAllTasks(){
        List<TaskDTO> result = taskServices.getAllTasks();
        return  result;
    }
}
