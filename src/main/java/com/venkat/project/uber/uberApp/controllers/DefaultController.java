package com.venkat.project.uber.uberApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

public class DefaultController {
	 @GetMapping("/")
	    public RedirectView redirectToSwaggerUi() {
	        return new RedirectView("http://ubs-env.eba-2wgxxxqw.us-east-1.elasticbeanstalk.com/swagger-ui/index.html");
	    }

}
