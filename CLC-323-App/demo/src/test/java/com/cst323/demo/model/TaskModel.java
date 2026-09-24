package com.cst323.demo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TaskModel {
    @NotNull(message="Title required")
    @Size(min=1, max=20, message="title must be between 1 & 20 characters")
    private String title;

    @NotNull(message="description required")
    private String description;

    @NotNull(message="priority required")
    @Size(min=1, max=20, message="priority must be between 1 & 20 characters")
    private String priority;

    @NotNull(message="Date required")
    private LocalDateTime dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
