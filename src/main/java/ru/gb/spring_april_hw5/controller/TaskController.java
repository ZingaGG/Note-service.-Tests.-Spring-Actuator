package ru.gb.spring_april_hw5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_april_hw5.model.Task;
import ru.gb.spring_april_hw5.model.TaskStatus;
import ru.gb.spring_april_hw5.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.findTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public void updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus taskStatus){
        taskService.changeTaskStatusByID(id, taskStatus);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTaskByID(id);
    }
}
