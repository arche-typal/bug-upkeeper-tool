package com.bugtrackertool.bugtrackertool.controllers;

import com.bugtrackertool.bugtrackertool.data.TicketRepository;
import com.bugtrackertool.bugtrackertool.models.Project;
import com.bugtrackertool.bugtrackertool.models.TestModel;
import com.bugtrackertool.bugtrackertool.models.Ticket;
import com.bugtrackertool.bugtrackertool.models.dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    //private String title = "Bug Tracker Tool";

//    @GetMapping()
    //@ResponseBody
//    public String dashboard(Model model) {
//        //return "I will be a dashboard?";
//        String testVariable = "Will this print??? Yes, it will.";
//
//        TestModel testmodel = new TestModel("Wutevah");
//        ticketRepository.save(testmodel);
//
//        Project aProject = new Project("Project Name");
//
//
//        model.addAttribute("testVar", testVariable);
//        model.addAttribute("testModel", testmodel);
//        //model.addAttribute("titleVar",title);
//        return "testtemplates";
//    }

    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute(new TicketDTO());
        return "ticket/create";
    }

    @PostMapping("create")
    public String processFormMethodName(Model model, @ModelAttribute TicketDTO ticketDTO) {

        Ticket newTicket = new Ticket(ticketDTO.getName(), ticketDTO.getDescription());

        ticketRepository.save(newTicket);
        return "ticket/create";
    }
}
