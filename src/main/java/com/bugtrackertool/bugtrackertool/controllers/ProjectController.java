package com.bugtrackertool.bugtrackertool.controllers;

import com.bugtrackertool.bugtrackertool.data.ProjectRepository;
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

    @GetMapping()
    //@ResponseBody
    public String projectDashboard(Model model) {


        return "project/index";
    }

    @GetMapping("create")
    public String createProject(Model model) {
        return "project/create";
    }

    @PostMapping("create")
    public String processFormMethodName(Model model, @RequestParam String name) {

        String newString = name;
        Project newProject = new Project(name);

        projectRepository.save(newProject);

        model.addAttribute("projectTest", newProject);
        model.addAttribute("nameTest", newString);
        return "project/individual-project";
    }

}
