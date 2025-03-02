package com.example.to_do_list.repositories;

import com.example.to_do_list.entities.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {

}
