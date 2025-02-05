package ru.felco.task_manager.service.implementation;

import org.springframework.stereotype.Service;
import ru.felco.task_manager.model.Task;
import ru.felco.task_manager.repository.TaskRepository;
import ru.felco.task_manager.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImplemented implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImplemented(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public void createTask(Task task) {
        repository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}