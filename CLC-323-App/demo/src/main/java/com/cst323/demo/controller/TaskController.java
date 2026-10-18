package com.cst323.demo.controller;

import com.cst323.demo.business.TaskServiceInterface;
import com.cst323.demo.model.TaskModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RequestMapping ("/Tasks")
@Controller
public class TaskController {
    @Autowired
    TaskServiceInterface taskService;
    @Autowired
    private ModelMapper modelMapper;
    private final static Logger log = LoggerFactory.getLogger(TaskController.class);

    @GetMapping("/")
    public String showTasks(Model model){
        log.info("entering the showTasks method");
        model.addAttribute("tasks", taskService.showAll());
        log.info("exiting the showTasks method");
        return "TaskList";
    }

    @GetMapping("/AddTask")
    public String addTaskForm(Model model){
        log.info("entering the addTaskForm method");
        model.addAttribute("title", "Add Task Form");
        model.addAttribute("taskModel", new TaskModel());
        log.info("exiting the addTaskForm method");
        return "CreateTask";
    }

    @PostMapping("/doAddTask")
    public String addTask(  @Valid @ModelAttribute("taskModel") TaskModel taskModel,
                            BindingResult bindingResult,
                            Model model){
        log.info("entering the addTask method");
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Add Task Form");
            log.error("exiting the addTask method with errors caused by the user");
            return "TaskList";
        }

        taskService.createTask(taskModel);
        log.info("exiting the addTask method");
        return "TaskList";
    }

}
