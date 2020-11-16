package com.bugtrackertool.bugtrackertool.controllers;

import com.bugtrackertool.bugtrackertool.data.ProjectRepository;
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

//    @Autowired
//    private ProjectRepository projectRepository;

    @GetMapping()
    public String ticketDashboard(Model model) {

        model.addAttribute("tickets", ticketRepository.findAll());
        return "ticket/index";
    }

    @GetMapping("/create")
    public String createTicket(Model model) {
        model.addAttribute(new Ticket());
//        model.addAttribute("projects", projectRepository.findAll());
        return "ticket/create";
    }

    @PostMapping("create")
    public String processTicket(Model model, @ModelAttribute Ticket ticket) {

        //Ticket newTicket = new Ticket(ticketDTO.getName(),ticketDTO.getDescription(),ticketDTO.getProject());

        ticketRepository.save(ticket);
        return "redirect:";
    }
}
