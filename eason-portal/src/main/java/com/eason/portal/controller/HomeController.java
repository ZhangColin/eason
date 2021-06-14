package com.eason.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author colin
 */
@Controller
//@RequestMapping(value = "/")
public class HomeController {
    @GetMapping(value = {"/index.html", "/"})
    public String index() {
        return "home/index";
    }
}
