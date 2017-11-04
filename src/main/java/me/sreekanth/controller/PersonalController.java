package me.sreekanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.sreekanth.dao.PersonalDAO;

@RestController
@EnableAutoConfiguration
public class PersonalController {
	
		@Value("${app.config.message}")
		public String message;
		
		PersonalDAO personalDAO;
		
		@Autowired
		public PersonalController(PersonalDAO personalDAO) {
			this.personalDAO = personalDAO;
		}

	    @RequestMapping("/searchByEmail")
	    public String index(@RequestParam("emailId") String emailId) {
	        return personalDAO.getData(emailId);
	    }
	    
	    @RequestMapping("/getMessage")
	    public String test() {
			return message;
	    }
	    


}
