package com.venkat.project.uber.uberApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

public class DefaultController {
	 @GetMapping("/")
	    public RedirectView redirectToSwaggerUi() {
	        return new RedirectView("/swagger-ui/index.html");
	    }

}
