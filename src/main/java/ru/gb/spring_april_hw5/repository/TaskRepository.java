package ru.gb.spring_april_hw5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_april_hw5.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
