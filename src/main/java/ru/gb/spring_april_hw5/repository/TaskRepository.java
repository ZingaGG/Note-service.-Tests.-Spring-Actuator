package ru.gb.spring_april_hw5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.spring_april_hw5.model.Task;
import ru.gb.spring_april_hw5.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTaskByStatus(TaskStatus taskStatus);

    @Modifying
    @Query("UPDATE Task t SET t.status = :taskStatus WHERE t.id = :id")
    @Transactional
    void changeTaskStatusByID(Long id, TaskStatus taskStatus);


}
