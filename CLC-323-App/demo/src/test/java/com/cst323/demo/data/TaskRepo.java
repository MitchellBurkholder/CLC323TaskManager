package com.cst323.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cst323.demo.data.entity.TaskEntity;


public interface TaskRepo extends JpaRepository<TaskEntity, Long> {
}
