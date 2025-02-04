package com.example.to_do_list.services;

import com.example.to_do_list.entities.Task;
import com.example.to_do_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long taskId){
        return taskRepository.findById(taskId);
    }
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }
    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }
    public void markTaskAsCompleted(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(t -> {
            t.markAsCompleted();
            taskRepository.save(t);
        });
    }
}
