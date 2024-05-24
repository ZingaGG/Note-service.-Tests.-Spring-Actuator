package ru.gb.spring_april_hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.spring_april_hw5.model.Task;
import ru.gb.spring_april_hw5.model.TaskStatus;
import ru.gb.spring_april_hw5.repository.TaskRepository;
import ru.gb.spring_april_hw5.service.TaskService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UpdateNoteServiceMock {
    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void updateNoteStatusTest(){
        // Блок предусловия
        Task taskToTest = new Task();
        taskToTest.setId(1L);
        taskToTest.setDescription("d1");
        taskToTest.setStatus(TaskStatus.NOT_STARTED);
        // Блок действия (вызова метода)
        taskService.changeTaskStatusByID(1L, TaskStatus.IN_PROGRESS);
        // Блок проверки действия
        verify(taskRepository).changeTaskStatusByID(1L, TaskStatus.IN_PROGRESS);
    }
}
