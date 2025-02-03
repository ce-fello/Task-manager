package ru.felco.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.felco.task_manager.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

}