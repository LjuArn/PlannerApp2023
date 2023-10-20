package com.example.plannerapp2023.web;


import com.example.plannerapp2023.domain.viewModel.TaskViewModel;
import com.example.plannerapp2023.service.TaskService;
import com.example.plannerapp2023.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {

        String loggedUsername = currentUser.getUsername();

        if (currentUser.getId() == null) {
            return "index";
        } else {

            Long curUserId = currentUser.getId();
            model.addAttribute("loggedUsername", loggedUsername);

            model.addAttribute("myTasks", taskService.findAllMyTasks(curUserId));


            List<TaskViewModel> allTasks = taskService.findAllTasksNoUser(curUserId);
            model.addAttribute("allTasks", allTasks);

            Long totalUnassignedTasks = taskService.countTasks(curUserId);
            model.addAttribute("totalUnassignedTasks", totalUnassignedTasks);

        }

        return "home";
    }

}




//            modelAndView.addObject("myTasks", taskService.findMyTasks(curUserId));
//
//          //  Long totalTasks = taskService.countTasks(curUserId);
//          //  modelAndView.addObject("totalUnassignedTasks", totalTasks);
//
//
//          //  Long myTotalTasks = taskService.countMyTasks(curUserId);
//           // modelAndView.addObject("totalMyTasks", myTotalTasks);
//
//