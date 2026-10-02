package com.cst323.demo.data;

import com.cst323.demo.data.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepo extends JpaRepository<TaskEntity, Long> {
}
