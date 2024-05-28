package ru.gb.spring_april_hw5.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_april_hw5.model.Task;
import ru.gb.spring_april_hw5.model.TaskStatus;
import ru.gb.spring_april_hw5.service.FileGateway;
import ru.gb.spring_april_hw5.service.TaskService;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    private final FileGateway fileGateway;
    private final Counter addTaskCount = Metrics.counter("add_task_count");

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){

        addTaskCount.increment();

        fileGateway.writeToFile(task.getDescription() + ".txt", task.toString());

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
