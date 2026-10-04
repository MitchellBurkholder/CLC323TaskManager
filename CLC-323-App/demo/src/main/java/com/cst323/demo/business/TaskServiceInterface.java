package com.cst323.demo.business;

import com.cst323.demo.data.entity.TaskEntity;
import com.cst323.demo.model.TaskModel;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskServiceInterface {
    public void deleteTask(long id);
    public List<TaskModel> showAll();
    public void createTask(TaskModel task);
    public void updateTask(TaskModel task, long id);
}
