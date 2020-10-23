package com.bugtrackertool.bugtrackertool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketController {

    @GetMapping()
    //@ResponseBody
    public String dashboard() {
        //return "I will be a dashboard?";
        return "form";
    }
}
