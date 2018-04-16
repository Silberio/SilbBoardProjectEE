package com.silb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Message Service Controller. Where all the fun happens.
 * 
 * <p>
 * Implements all the methods from the service DAO through an autowired
 * MessageService class.	
 * </p>
 * All data is stored locally and dies upon application closing. Later version
 * will include JDBC implementation.
 * 
 * @author silberio_stalone
 *
 */
@Controller
public class MessageController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home.html";
	}
	

}
