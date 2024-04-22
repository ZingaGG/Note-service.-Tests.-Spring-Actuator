package ru.gb.spring_april_hw5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.spring_april_hw5.model.Task;
import ru.gb.spring_april_hw5.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

}
