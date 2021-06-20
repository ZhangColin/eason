package com.eason.portal.controller;

import com.eason.portal.request.RegisterCommand;
import com.eason.portal.response.UserDto;
import com.eason.portal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author colin
 */
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register.html")
    public String register() {
        return "user/register";
    }

    @PostMapping(value = "register")
    public void register(RegisterCommand command) {
        userService.register(command);
    }


    @GetMapping(value = "/login.html")
    public String login() {
        return "user/login";
    }

    @PostMapping(value = "login")
    public String login(String account, String password, HttpServletRequest request) {
        final UserDto user = userService.findByUserName(account);
        if (user == null) {
            log.info("无此用户");
        } else if (user.getPasswordEncrypt().equals(password)) {
            final HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {
            log.info("密码不对");
        }

        return "product/list";
    }


}
