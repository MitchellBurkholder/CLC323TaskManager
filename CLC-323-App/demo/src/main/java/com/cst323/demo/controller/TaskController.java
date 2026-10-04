package com.cst323.demo.controller;

import com.cst323.demo.business.TaskServiceInterface;
import com.cst323.demo.model.TaskModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
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

    @GetMapping("/Tasks")
    public String showTasks(Model model){
        model.addAttribute("Tasks", taskService.showAll());
        return "tasks";
    }

    @GetMapping("/AddTask")
    public String addTaskForm(Model model){
        model.addAttribute("title", "Add Task Form");
        model.addAttribute("taskModel", new TaskModel());
        return "AddTask";
    }

    @PostMapping("/doAddTask")
    public String addTask(  @Valid @ModelAttribute("taskModel") TaskModel taskModel,
                            BindingResult bindingResult,
                            Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Add Task Form");
            return "AddTask";
        }

        taskService.createTask(taskModel);
        return showTasks(model);
    }

    /*@GetMapping("/editTask/{id}")
    public String editTaskForm(@PathVariable int id, Model model)
    {
        E product = productService.findById(id);

        model.addAttribute("title", "Edit Product Form");
        model.addAttribute("productModel", product);

        return "EditTask";
    }*/

    @PostMapping("/doUpdateProduct")
    public String updateProduct(
            @Valid @ModelAttribute("productModel") TaskModel taskModel,
            BindingResult bindingResult,
            Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Edit Task Form");
            return "EditTask";
        }

        taskService.updateTask(taskModel, 1);
        return showTasks(model);
    }



}
