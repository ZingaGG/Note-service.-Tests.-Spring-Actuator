package ru.gb.spring_april_hw5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.spring_april_hw5.model.Task;
import ru.gb.spring_april_hw5.model.TaskStatus;
import ru.gb.spring_april_hw5.repository.TaskRepository;
import ru.gb.spring_april_hw5.service.TaskService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SpringAprilHw5ApplicationTests {
	@Autowired
	private TaskService taskService;

	@MockBean
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
