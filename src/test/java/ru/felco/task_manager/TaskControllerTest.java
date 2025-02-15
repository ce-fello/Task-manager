package ru.felco.task_manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import ru.felco.task_manager.controller.TaskController;
import ru.felco.task_manager.model.Task;
import ru.felco.task_manager.service.TaskService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    private TaskService service;

    @Mock
    private Model model;

    @InjectMocks
    private TaskController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(new Task(), new Task());
        when(service.getAllTasks()).thenReturn(tasks);
        String viewName = controller.getAllTasks(model);
        assertEquals("index", viewName);
        verify(model).addAttribute("tasks", tasks);
        verify(service).getAllTasks();
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        String viewName = controller.createTask(task);
        assertEquals("index", viewName);
        verify(service).createTask(task);
    }

    @Test
    void testUpdateTask() {
        Task task = new Task();
        String viewName = controller.updateTask(task);
        assertEquals("index", viewName);
        verify(service).updateTask(task);
    }

    @Test
    void testDeleteTask() {
        Long id = 1L;
        String viewName = controller.deleteTask(id);
        assertEquals("index", viewName);
        verify(service).deleteTask(id);
    }
}