package ru.felco.task_manager.service.implementation;

import org.springframework.stereotype.Service;
import ru.felco.task_manager.model.Task;
import ru.felco.task_manager.repository.TaskRepository;
import ru.felco.task_manager.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImplemented implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImplemented(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}