package com.bugtrackertool.bugtrackertool.controllers;

import com.bugtrackertool.bugtrackertool.data.ProjectRepository;
import com.bugtrackertool.bugtrackertool.data.TicketRepository;
import com.bugtrackertool.bugtrackertool.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

//    @Autowired
//    private TicketRepository ticketRepository;

    @GetMapping()
    //@ResponseBody
    public String projectDashboard(Model model) {

        model.addAttribute("projects", projectRepository.findAll());
        return "project/index";
    }

    @GetMapping("create")
    public String createProject(Model model) {
        model.addAttribute(new Project());
//        model.addAttribute("tickets", ticketRepository.findAll());
        return "project/create";
    }

    @PostMapping("create")
    public String processFormMethodName(Model model, @ModelAttribute Project project) {

        projectRepository.save(project);

//        model.addAttribute("projectTest", newProject);
//        model.addAttribute("nameTest", newString);
        return "redirect:";
    }

}
