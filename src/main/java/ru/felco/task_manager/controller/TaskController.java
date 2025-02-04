package ru.felco.task_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.felco.task_manager.model.Task;
import ru.felco.task_manager.service.implementation.TaskServiceImplemented;

import java.util.List;

@Controller
public class TaskController {
    private final TaskServiceImplemented taskService;

    public TaskController(TaskServiceImplemented taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/add")
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task added";
    }

    @PutMapping("/update_task")
    public String updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
        return "Task updated";
    }

    @DeleteMapping("/delete_task/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}