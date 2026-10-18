package com.cst323.demo.business;

import com.cst323.demo.data.entity.TaskEntity;
import com.cst323.demo.model.TaskModel;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.cst323.demo.data.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements TaskServiceInterface {
    @Autowired
    private TaskRepo repo;
    @Autowired
    private ModelMapper modelMapper;
    private final static Logger log = LoggerFactory.getLogger(TaskService.class);

    @Override
    public List<TaskModel> showAll() {
        log.info("Entering showAll method");
        List<TaskEntity> allTasks = repo.findAll();
        List<TaskModel> displayList = new ArrayList<>();
        // maps Entity fields to the model fields
        allTasks.forEach(item -> displayList.add(modelMapper.map(item, TaskModel.class)));
        log.info("Exiting showAll Method ");
        return displayList;
    }

    @Override
    public void createTask(TaskModel task) {
        log.info("Entering createTask method");
        TaskEntity entity = new TaskEntity();
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
}
