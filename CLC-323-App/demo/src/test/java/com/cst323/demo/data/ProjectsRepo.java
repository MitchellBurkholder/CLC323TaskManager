package com.cst323.demo.data;

import com.cst323.demo.data.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepo extends JpaRepository<ProjectEntity, Long> {
}
