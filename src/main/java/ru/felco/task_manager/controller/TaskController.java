package ru.felco.task_manager.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.felco.task_manager.model.Task;
import ru.felco.task_manager.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService taskService) {
        this.service = taskService;
    }

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = service.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/save_task")
    public String createTask(@RequestBody Task task) {
        service.createTask(task);
        return "index";
    }

    @PutMapping("/update_task")
    public String updateTask(@RequestBody Task task) {
        service.updateTask(task);
        return "index";
    }

    @DeleteMapping("/delete_task/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "index";
    }
}