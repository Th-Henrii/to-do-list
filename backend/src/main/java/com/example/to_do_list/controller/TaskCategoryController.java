package com.example.to_do_list.controller;

import com.example.to_do_list.DTO.TaskCategoryDTO;
import com.example.to_do_list.entities.TaskCategory;
import com.example.to_do_list.services.TaskCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/taskCategory")
public class TaskCategoryController {
    private TaskCategoryService taskCategoryService;

    public TaskCategoryController(TaskCategoryService taskCategoryService){
        this.taskCategoryService = taskCategoryService;
    }

    @GetMapping
    public List<TaskCategoryDTO> getAllTaskCategory(){
        try{
            List<TaskCategoryDTO> response = taskCategoryService.getAllTaskCategory();
            return response;
        } catch (Exception e) {
            System.out.println("Error get all taskCategory in controller.");
            System.out.println("Error: "+e.getMessage());
        }
        return List.of();
    }
    @PostMapping
    public TaskCategory addTaskCategory(@RequestBody TaskCategoryDTO taskCategoryDTO){
        try{
            TaskCategory response = taskCategoryService.addTaskCategory(taskCategoryDTO);
            return response;
        } catch (Exception e) {
            System.out.println("Error create taskCategory in controller.");
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }
    @PutMapping("/{id}")
    public TaskCategory uptadeTaskCategory(@PathVariable Long id,@RequestBody TaskCategoryDTO taskCategoryDTO){
        try {
            TaskCategory response = taskCategoryService.updateTaskCategory(id,taskCategoryDTO);
            return response;
        } catch (Exception e) {
            System.out.println("Error update taskCategory in controller.");
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void removeTaskCategory(@PathVariable Long id){
        try {
            taskCategoryService.removeTaskCategory(id);
        } catch (Exception e) {
            System.out.println("Error remove taskCategory in controller.");
            System.out.println("Error: "+e.getMessage());
        }
    }
}
