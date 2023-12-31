package com.example.plannerapp2023.web;


import com.example.plannerapp2023.domain.bindingModel.TaskAddBindingModel;
import com.example.plannerapp2023.domain.serverModel.TaskServiceModel;
import com.example.plannerapp2023.service.TaskService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        }
        return "task-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        taskService.addTask(modelMapper.map(taskAddBindingModel, TaskServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/assignMe/{id}")
    private String assignMeTask(@PathVariable("id") Long id) {
        taskService.assaignMeTask(id);
        return "redirect:/";
    }

    @GetMapping("/return/{id}")
    private String returnTask(@PathVariable("id") Long id) {
        taskService.returnTask(id);
        return "redirect:/";
    }


    @GetMapping("/del/{id}")
    private String delateTask(@PathVariable("id") Long id) {
        taskService.del(id);
        return "redirect:/";
    }



}
