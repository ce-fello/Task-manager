package ru.felco.task_manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.felco.task_manager.model.Task;
import ru.felco.task_manager.repository.TaskRepository;
import ru.felco.task_manager.service.implementation.TaskServiceImplemented;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskServiceImplementedTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskServiceImplemented service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(new Task(), new Task());
        when(repository.findAll()).thenReturn(tasks);
        List<Task> result = service.getAllTasks();
        assertEquals(tasks, result);
        verify(repository).findAll();
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        service.createTask(task);
        verify(repository).save(task);
    }

    @Test
    void testUpdateTask() {
        Task task = new Task();
        when(repository.save(task)).thenReturn(task);
        Task result = service.updateTask(task);
        assertEquals(task, result);
        verify(repository).save(task);
    }

    @Test
    void testDeleteTask() {
        Long id = 1L;
        service.deleteTask(id);
        verify(repository).deleteById(id);
    }
}