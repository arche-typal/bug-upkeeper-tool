package com.bugtrackertool.bugtrackertool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketController {

    @GetMapping()
    //@ResponseBody
    public String dashboard(Model model) {
        //return "I will be a dashboard?";
        String testVariable = "Will this print??? Yes, it will.";

        model.addAttribute("testVar", testVariable);
        return "testtemplates";
    }
}
