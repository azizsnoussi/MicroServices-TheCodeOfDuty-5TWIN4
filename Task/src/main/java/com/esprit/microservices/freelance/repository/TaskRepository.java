package com.esprit.microservices.freelance.repository;

import com.esprit.microservices.freelance.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t where t.title like :title")
    public Page<Task> tasksByTitle(@Param("title") String title, Pageable pageable);
}
