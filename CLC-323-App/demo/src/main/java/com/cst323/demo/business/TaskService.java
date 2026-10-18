
package com.cst323.demo.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cst323.demo.data.TaskRepo;
import com.cst323.demo.data.entity.TaskEntity;
import com.cst323.demo.model.TaskModel;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(TaskService.class);

    @Override
    public List<TaskModel> showAll() {
        log.info("Entering showAll method");

        List<TaskEntity> allTasks = repo.findAll();
        List<TaskModel> displayList = new ArrayList<>();

        allTasks.forEach(item -> displayList.add(
                modelMapper.map(item, TaskModel.class)));

        log.info("Exiting showAll method");
        return displayList;
    }

    @Override
    public void createTask(TaskModel task) {
        log.info("Entering createTask method");

        TaskEntity entity = new TaskEntity();

        // Temporary IDs for the confirmed test records.
        // Replace with authenticated user and selected project
        // before supporting multiple users/projects.
        entity.setProjectId(1L);
        entity.setAssignedUserId(1L);

        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setDescription(task.getDescription());
        entity.setDueDate(task.getDueDate());
        entity.setFullName(task.getFullName());
        entity.setPriority(task.getPriority());
        entity.setTitle(task.getTitle());

        repo.save(entity);

        log.info("Exiting createTask method");
    }

    @Override
    public TaskModel getTask(long id) {
        log.info("Entering getTask for id={}", id);

        TaskEntity entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task not found"));

        log.info("Exiting getTask for id={}", id);

        return modelMapper.map(entity, TaskModel.class);
    }

    @Override
    public void updateTask(long id, TaskModel task) {
        log.info("Entering updateTask for id={}", id);

        TaskEntity entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task not found"));

        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setFullName(task.getFullName());
        entity.setPriority(task.getPriority());
        entity.setDueDate(task.getDueDate());
        entity.setUpdatedAt(LocalDateTime.now());

        // Existing project/user IDs are preserved.

        repo.save(entity);

        log.info("Exiting updateTask for id={}", id);
    }

    @Override
    public void deleteTask(long id) {
        log.info("Entering deleteTask for id={}", id);

        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task not found");
        }

        repo.deleteById(id);

        log.info("Exiting deleteTask for id={}", id);
    }
}
