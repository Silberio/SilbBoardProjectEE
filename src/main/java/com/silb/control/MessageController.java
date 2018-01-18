package com.silb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
}

///**
// * Message Service Controller. Where all the fun happens.
// * 
// * <p>
// * Implements all the methods from the service DAO through an autowired
// * MessageService class.
// * </p>
// * All data is stored locally and dies upon application closing. Later version
// * will include JDBC implementation.
// * 
// * @author silberio_stalone
// *
// */
//@Controller
//public class MessageController {
//
//	@Autowired
//	private MessageService messageService;
//
//	private Message msg;
//	private AtomicInteger count = new AtomicInteger(0);
//	private static final String USERNAME = "Silberio";
//	private static final String PASSWORD = "Google123";
//	private boolean isLoggedIn = false;
//
//	/**
//	 * Re-routing of the main page to a form for submitting a new message.
//	 * <p>
//	 * Any first requests to the /home page returns /messageform to input a new
//	 * message
//	 * </p>
//	 * 
//	 * @return /messageform
//	 */
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String messageForm() {
//		return "login";
//	}
//
////	@RequestMapping(value = "/login", method = RequestMethod.POST)
////	public String login(HttpServletRequest request) {
////		if (request.getParameter("user").equals(USERNAME) && request.getParameter("pass").equals(PASSWORD)) {
////			isLoggedIn = true;
////			return "messageform";
////		} else {
////			isLoggedIn = false;
////			return "login";
////		}
////	}
//
//	/**
//	 * Adds a new message to the board
//	 * <p>
//	 * Creates a new Message object with input from an HTTP Request. The request is
//	 * added as a parameter to the message.setMessage() method. The new Message
//	 * object is added to the MessageService repository before being added to a
//	 * model, ergo the actual webpage.
//	 * </p>
//	 * If the message is empty, a default value of "Privet Mir" (Hello world, in
//	 * Russian) is added and the User is set as Guest User. For now the user is
//	 * hardcoded.
//	 * 
//	 * @param request
//	 *            the request taken from a form in /messageform
//	 * @param model
//	 *            the model attribute to which the message is added
//	 * @return /home the webpage in which messages are displayed
//	 */
//	@RequestMapping(value = "/board", method = RequestMethod.POST)
//	public String message(HttpServletRequest request, Model model) {
//		msg = new Message();
//		
//		messageService.insertMessage(msg);
//
//		model.addAttribute("messages", messageService.getAllMessages());
//		return "board";
//	}
//
//	/**
//	 * Deletes a message by ID
//	 * <p>
//	 * This method is called through a link in each newmessage div in the /home
//	 * page. Each link is mapped to its' specific message. When the <i>Delete
//	 * Post</i> link is clicked, a GET request is sent passing the message id from
//	 * the message and this method is invoked, deleting the message from the
//	 * repository.
//	 * </p>
//	 * This method does not actually delete the message from the /home page, but
//	 * deletes it from the repository, and next time /home is loaded, it reloads all
//	 * messaes, sans the ones that got deleted.
//	 * 
//	 * @param msgID
//	 *            ID of the message to be deleted
//	 * @return redirects to /home.
//	 */
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String deleteMessage(@RequestParam(name = "msgID") String msgID) {
//		int id = Integer.parseInt(msgID);
//		messageService.removeMessageById(id);
//		return "redirect:/home";
//	}
//
//}
