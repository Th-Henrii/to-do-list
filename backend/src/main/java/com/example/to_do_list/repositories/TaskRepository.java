package com.example.to_do_list.repositories;

import com.example.to_do_list.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
