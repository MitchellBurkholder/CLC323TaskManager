package com.cst323.demo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class ProjectModel {

    @NotNull(message="first name is required a field")
    @Size(min=1, max=100, message="first name must be between 1 & 100 characters")
    private String name;

    @NotNull(message="You have to explain what the project is for")
    private String description;

    @NotNull(message="status is required a field")
    @Size(min=1, max=20, message="role must be between 1 & 20 characters")
    private String status;

    @NotNull(message="There must be a due date")
    private LocalDateTime dueDate;

    public String getName() {return name; }

    public void setName(String name) {this.name = name; }

    public LocalDateTime getDueDate() {return dueDate; }

    public void setDueDate(LocalDateTime dueDate) {this.dueDate = dueDate; }

    public String getStatus() {return status; }

    public void setStatus(String status) {this.status = status; }

    public String getDescription() {return description; }

    public void setDescription(String description) {this.description = description; }
}
