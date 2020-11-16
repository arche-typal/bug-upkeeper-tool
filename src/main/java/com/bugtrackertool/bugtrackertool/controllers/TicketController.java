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

    @GetMapping()
    public String ticketDashboard(Model model) {

        model.addAttribute("tickets", ticketRepository.findAll());
        return "ticket/index";
    }

    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute(new TicketDTO());
        return "ticket/create";
    }

    @PostMapping("create")
    public String processFormMethodName(Model model, @ModelAttribute TicketDTO ticketDTO) {

        Ticket newTicket = new Ticket(ticketDTO.getName(), ticketDTO.getDescription());

        ticketRepository.save(newTicket);
        return "ticket";
    }
}
