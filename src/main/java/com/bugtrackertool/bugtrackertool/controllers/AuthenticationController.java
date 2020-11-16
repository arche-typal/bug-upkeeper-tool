package com.bugtrackertool.bugtrackertool.controllers;

import com.bugtrackertool.bugtrackertool.data.UserRepository;
import com.bugtrackertool.bugtrackertool.models.User;
import com.bugtrackertool.bugtrackertool.models.dto.LoginDTO;
import com.bugtrackertool.bugtrackertool.models.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;
import java.lang.*;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private static final String usernameSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer usernameId = (Integer) session.getAttribute(usernameSessionKey);
        if (usernameId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(usernameId);

        if(!(user.isPresent())) {
            return null;
        }

        return user.get();
    }

    private static void setUsernameSessionKey(HttpSession session, User user) {
        session.setAttribute(usernameSessionKey, user.getId());
        session.setAttribute("loggedUser", user);
    }

    @GetMapping("/register")
    public String displayRegisterForm(Model model) {
        model.addAttribute(new RegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute RegisterDTO registerDTO) {
        User userToStore = new User(registerDTO.getUsername(), registerDTO.getPassword());
        userRepository.save(userToStore);

        return "redirect:/project";
    }

    @GetMapping("/login")
    public String displayLogin(Model model) {
        model.addAttribute(new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute LoginDTO loginDTO, Model model, HttpServletRequest request) {
        User userLogged = userRepository.findByUsername(loginDTO.getUsername());
        setUsernameSessionKey(request.getSession(), userLogged);
        //request.setAttribute("loggedUser", userLogged);
        //User seeValue = getUserFromSession(request.getSession());

        return "redirect:/project";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
