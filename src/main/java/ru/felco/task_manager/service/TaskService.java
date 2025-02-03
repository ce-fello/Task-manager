package ru.felco.task_manager.service;

import ru.felco.task_manager.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long id);
}
