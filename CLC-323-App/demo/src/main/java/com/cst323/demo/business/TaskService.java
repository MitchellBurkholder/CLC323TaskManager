package com.cst323.demo.business;

import com.cst323.demo.data.entity.TaskEntity;
import com.cst323.demo.model.TaskModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.cst323.demo.data.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements TaskServiceInterface{
    @Autowired
    private TaskRepo repo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void deleteTask(long id){
        repo.deleteById(id);
    }

    @Override
    public List<TaskModel> showAll() {
        List<TaskEntity> allTasks = repo.findAll();
        List<TaskModel> displayList = new ArrayList<>();
        // maps Entity fields to the model fields
        allTasks.forEach(item->displayList.add(modelMapper.map(item, TaskModel.class)));
        return displayList;
    }

    @Override
    public void createTask(TaskModel task){
        TaskEntity entity = new TaskEntity();
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setDescription(task.getDescription());
        entity.setDueDate(task.getDueDate());
        entity.setFullName(task.getFullName());
        entity.setPriority(task.getPriority());
        entity.setTitle(task.getTitle());
        repo.save(entity);
    }

    @Override
    public void updateTask(TaskModel task, long id){
        TaskEntity entity = repo.findById(id).orElse(null);

        if(entity != null){
            entity.setUpdatedAt(LocalDateTime.now());
            entity.setDescription(task.getDescription());
            entity.setDueDate(task.getDueDate());
            entity.setFullName(task.getFullName());
            entity.setPriority(task.getPriority());
            entity.setTitle(task.getTitle());
            repo.save(entity);
        }
    }




}
