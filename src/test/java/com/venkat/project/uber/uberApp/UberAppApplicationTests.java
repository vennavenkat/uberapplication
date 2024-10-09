package com.venkat.project.uber.uberApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.venkat.project.uber.uberApp.services.EmailSenderService;

@SpringBootTest
class UberAppApplicationTests {
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		
		emailSenderService.sendEmail("vennavenkat1999@gmail.com", 
					"This is Tresting mail", 
					"Body of the mail");
	}
	
	@Test
	void sendEmailMultiple() {
		String emails[]= {
				"venkatkumarvenna@gmail.com",
				"vennavenkat1999@gmail.com"
		};
		
		emailSenderService.sendEmail(emails, 
					"This is Tresting mail", 
					"Body of the mail");
	}

}
