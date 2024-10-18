package com.venkat.project.uber.uberApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DefaultController {

    @GetMapping("/")
    public RedirectView redirectToGoogle() {
        return new RedirectView("https://www.google.com");
    }
}
