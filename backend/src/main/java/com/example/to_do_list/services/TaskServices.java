package com.example.to_do_list.services;

import com.example.to_do_list.DTO.TaskDTO;
import com.example.to_do_list.entities.Task;
import com.example.to_do_list.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {

    @Autowired(required = true)
    private TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
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
        task.setCreatedAt(taskDTO.getCreatedAt());
        return taskRepository.save(task);
    }


    @Transactional(readOnly = true)
    public Task updateTask(Long idTask, TaskDTO taskDTO) {
        Optional<Task> taskOptional = taskRepository.findById(idTask);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setStatus(taskDTO.getStatus());
            taskRepository.save(task);  // Salva a task no banco

            return task;
        } else {
            // Lança uma exceção caso a task não seja encontrada
            throw new EntityNotFoundException("Task com ID " + idTask + " não encontrada");
        }
    }

    @Transactional(readOnly = true)
    public void removeTask(Long idTask){
        Optional<Task> taskOptional = taskRepository.findById(idTask);
        if (taskOptional.isPresent()) {
            taskRepository.deleteById(idTask);
        } else {
            throw new EntityNotFoundException("Task com ID " + idTask + " não encontrada");
        }
    }
}
