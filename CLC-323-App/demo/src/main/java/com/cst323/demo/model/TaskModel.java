
package com.cst323.demo.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskModel {

    private Long id;

    // Database relationship fields
    private Long projectId;
    private Long assignedUserId;

    @NotNull(message = "Title required")
    @Size(min = 1, max = 20, message = "Title must be between 1 and 20 characters")
    private String title;

    @NotNull(message = "Description required")
    private String description;

    @NotNull(message = "Priority required")
    @Size(min = 1, max = 20, message = "Priority must be between 1 and 20 characters")
    private String priority;

    @NotNull(message = "A person must be assigned")
    @Size(min = 1, max = 100, message = "Full name must be between 1 and 100 characters")
    private String fullName;

    @NotNull(message = "Date required")
    private LocalDateTime dueDate;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
