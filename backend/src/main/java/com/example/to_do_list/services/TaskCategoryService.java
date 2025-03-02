package com.example.to_do_list.services;

import com.example.to_do_list.DTO.TaskCategoryDTO;
import com.example.to_do_list.DTO.TaskDTO;
import com.example.to_do_list.entities.Task;
import com.example.to_do_list.entities.TaskCategory;
import com.example.to_do_list.repositories.TaskCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCategoryService {

    private TaskCategoryRepository taskRepository;

    public TaskCategoryService(TaskCategoryRepository taskRepository){this.taskRepository = taskRepository;}

    @Transactional(readOnly = true)
    public List<TaskCategoryDTO> getAllTaskCategory(){
        try {
            List<TaskCategory> response = taskRepository.findAll();
            return  response.stream().map(x -> new TaskCategoryDTO(x)).toList();
        }catch (Exception e){
            System.out.println("Error for get all category of tasks in services."+e);
            System.out.println("ERRO: "+e.getMessage());
        }
        return List.of();
    }

    @Transactional(readOnly = true)
    public TaskCategory addTaskCategory(TaskCategoryDTO taskCategoryDTO){
        try{
            TaskCategory taskCategory = new TaskCategory();
            taskCategory.setName(taskCategoryDTO.getName());

            return taskRepository.save(taskCategory);
        } catch (Exception e) {
            System.out.println("Error crete category of tasks in services."+e);
            System.out.println("ERRO: "+e.getMessage());
        }
        return null;
    }
    @Transactional(readOnly = true)
    public void removeTaskCategory(Long id){
        try{
        Optional<TaskCategory> taskCategoryOptional = taskRepository.findById(id);
            if (taskCategoryOptional.isPresent()) {
                taskRepository.deleteById(id);
            } else {
                throw new EntityNotFoundException("Task com ID " + id + " não encontrada");
            }
        } catch (Exception e) {
            System.out.println("Error remove category of tasks in services."+e);
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    public TaskCategory updateTaskCategory(Long id,TaskCategoryDTO taskCategoryDTO){
        try{
            Optional<TaskCategory> taskCategoryOptional = taskRepository.findById(id);
            if (taskCategoryOptional.isPresent()) {
                TaskCategory taskCategory = taskCategoryOptional.get();
                taskCategory.setName(taskCategoryDTO.getName());

                return taskRepository.save(taskCategory);
            } else {
                // Lança uma exceção caso a task não seja encontrada
                throw new EntityNotFoundException("Task com ID " + id + " não encontrada");
            }
        } catch (Exception e) {
            System.out.println("Error update category of tasks in services."+e);
            System.out.println("ERRO: "+e.getMessage());
        }
        return null;
    }
}
