package com.example.to_do_list.services;

import com.example.to_do_list.DTO.TaskDTO;
import com.example.to_do_list.entities.Task;
import com.example.to_do_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServices {

    @Autowired(required = true)
    private TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll(); // Busca todas as tarefas do banco
        return tasks.stream().map(x -> new TaskDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public TaskDTO findById(Long taskId){
        Task result = taskRepository.findById(taskId).get();
        TaskDTO dto = new TaskDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public Task addTask(TaskDTO taskDTO){
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setTitle(taskDTO.getTitle());
        task.setStatus(taskDTO.getStatus());
        return taskRepository.save(task);
    }
}
