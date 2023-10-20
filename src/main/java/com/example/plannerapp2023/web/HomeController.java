package com.example.plannerapp2023.web;


import com.example.plannerapp2023.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private  final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index(Model model) {

        String loggedUsername = currentUser.getUsername();
        if (currentUser.getId() == null) {
           return "index";
        } else {



        }

        return "home";
    }

}


//          Long curUserId = currentUser.getId();
//            modelAndView.addObject("loggedUsername", loggedUsername);
//            modelAndView.addObject("allTasks", taskService.findAllTasksNoUser(curUserId));
//            modelAndView.addObject("myTasks", taskService.findMyTasks(curUserId));
//
//          //  Long totalTasks = taskService.countTasks(curUserId);
//          //  modelAndView.addObject("totalUnassignedTasks", totalTasks);
//
//
//          //  Long myTotalTasks = taskService.countMyTasks(curUserId);
//           // modelAndView.addObject("totalMyTasks", myTotalTasks);
//
//            modelAndView.setViewName("home");