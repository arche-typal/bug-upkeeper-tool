package com.bugtrackertool.bugtrackertool.controllers;

import com.bugtrackertool.bugtrackertool.data.TicketRepository;
import com.bugtrackertool.bugtrackertool.models.Project;
import com.bugtrackertool.bugtrackertool.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    //private String title = "Bug Tracker Tool";

    @GetMapping()
    //@ResponseBody
    public String dashboard(Model model) {
        //return "I will be a dashboard?";
        String testVariable = "Will this print??? Yes, it will.";

        TestModel testmodel = new TestModel("Wutevah");
        ticketRepository.save(testmodel);

        Project aProject = new Project("Project Name");


        model.addAttribute("testVar", testVariable);
        model.addAttribute("testModel", testmodel);
        //model.addAttribute("titleVar",title);
        return "testtemplates";
    }
}
