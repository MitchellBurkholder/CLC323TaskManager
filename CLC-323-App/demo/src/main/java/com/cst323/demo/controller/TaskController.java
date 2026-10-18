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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            return "CreateTask";
        }

        taskService.createTask(taskModel);
        log.info("exiting the addTask method");
        return "redirect:/Tasks/";
    }

    @GetMapping("/{id}/edit")
    public String editTaskForm(@PathVariable long id, Model model) {
        log.info("Entering editTaskForm for id={}", id);
        model.addAttribute("taskId", id);
        model.addAttribute("taskModel", taskService.getTask(id));
        log.info("Exiting editTaskForm for id={}", id);
        return "UpdateTask";
    }

    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable long id,
                             @Valid @ModelAttribute("taskModel") TaskModel taskModel,
                             BindingResult bindingResult, Model model,
                             RedirectAttributes redirectAttributes) {
        log.info("Entering updateTask for id={}", id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("taskId", id);
            log.warn("Invalid edit request for task id={}", id);
            return "UpdateTask";
        }
        taskService.updateTask(id, taskModel);
        redirectAttributes.addFlashAttribute("successMessage", "Task updated successfully.");
        log.info("Exiting updateTask for id={}", id);
        return "redirect:/Tasks/";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id, RedirectAttributes redirectAttributes) {
        log.info("Entering deleteTask for id={}", id);
        taskService.deleteTask(id);
        redirectAttributes.addFlashAttribute("successMessage", "Task deleted successfully.");
        log.info("Exiting deleteTask for id={}", id);
        return "redirect:/Tasks/";
    }
}
