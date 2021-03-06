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

import java.util.Optional;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping()
    public String ticketDashboard(Model model, @RequestParam(required = false) Integer projectId) {

        if(projectId == null) {
            model.addAttribute("tickets", ticketRepository.findAll());
        }
        else {
            Optional<Project> projectResult = projectRepository.findById(projectId);
            Project project = projectResult.get();
            model.addAttribute("tickets", project.getTickets());
        }
        return "ticket/index";
    }

    @GetMapping("/create")
    public String createTicket(Model model) {
        model.addAttribute(new Ticket());
        model.addAttribute("projects", projectRepository.findAll());
        return "ticket/create";
    }

    @PostMapping("/create")
    public String processTicket(@ModelAttribute Ticket ticket) {

        ticketRepository.save(ticket);
        return "redirect:";
    }

    @GetMapping("/edit/{ticketId}")
    public String displayEditForm(Model model, @PathVariable Integer ticketId) {

        model.addAttribute("ticket",ticketRepository.findById(ticketId).get());
        model.addAttribute("projects", projectRepository.findAll());
        return "ticket/edit";
    }

    @PostMapping("/edit/{ticketId}")
    public String processEditForm(@ModelAttribute Ticket ticket, Integer ticketId) {


        Ticket newTicket = new Ticket(ticketId, ticket.getName(), ticket.getDescription(), ticket.getProject());
        ticketRepository.save(newTicket);

        return "redirect:/ticket";
    }

    @GetMapping("/delete/{ticketId}")
    public String delete(Model model, @PathVariable Integer ticketId) {

        ticketRepository.deleteById(ticketId);
        return "redirect:/ticket";
    }

}
