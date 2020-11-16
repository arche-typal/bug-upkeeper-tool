package com.bugtrackertool.bugtrackertool;

import com.bugtrackertool.bugtrackertool.controllers.AuthenticationController;
import com.bugtrackertool.bugtrackertool.data.UserRepository;
import com.bugtrackertool.bugtrackertool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Whitelist extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/login", "/register");

    private static boolean isInWhitelist(String path) {
        for (String pathRoot : whitelist) {
            if (path.equals(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //Allow whitelisted pages to be returned if not signed-in
        if(isInWhitelist(request.getRequestURI())) {
            //allow request to proceed
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        //If true, user is logged-in
        if (user != null) {
            return true;
        }

        //If false, user is not logged-in
        response.sendRedirect("/login");
        return false;
    }

}
