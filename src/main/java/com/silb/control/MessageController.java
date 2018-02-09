package com.silb.control;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.silb.model.Message;
import com.silb.service.MessageService;

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

	@Autowired
	private MessageService messageService;

	private Message msg;
	private AtomicInteger count = new AtomicInteger(0);

	/**
	 * Re-routing of the main page to a form for submitting a new message.
	 * <p>
	 * Any first requests to the /home page returns /messageform to input a new
	 * message
	 * </p>
	 * 
	 * @return /messageform
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String messageForm() {
		return "home";
	}

	/**
	 * Adds a new message to the board
	 * <p>
	 * Creates a new Message object with input from an HTTP Request. The request is
	 * added as a parameter to the message.setMessage() method. The new Message
	 * object is added to the MessageService repository before being added to a
	 * model, ergo the actual webpage.
	 * </p>
	 * If the message is empty, a default value of "Privet Mir" (Hello world, in
	 * Russian) is added and the User is set as Guest User. For now the user is
	 * hardcoded.
	 * 
	 * @param request
	 *            the request taken from a form in /messageform
	 * @param model
	 *            the model attribute to which the message is added
	 * @return /home the webpage in which messages are displayed
	 */
	@RequestMapping(value = "/messageform", method = RequestMethod.POST)
	public String message(HttpServletRequest request, Model model) {
		msg = new Message();

		if (request.getParameter("msg").equals("")) {
			msg.setMessage("Privet Mir");
			msg.setUser("Guest User");
		} else {
			msg.setId(count.incrementAndGet());
			msg.setMessage(request.getParameter("msg"));
			msg.setUser("Silb");
		}
		messageService.insertMessage(msg);

		model.addAttribute("messages", messageService.getAllMessages());
		return "messageform";
	}

	/**
	 * Deletes a message by ID
	 * <p>
	 * This method is called through a link in each newmessage div in the /home
	 * page. Each link is mapped to its' specific message. When the <i>Delete
	 * Post</i> link is clicked, a GET request is sent passing the message id from
	 * the message and this method is invoked, deleting the message from the
	 * repository.
	 * </p>
	 * This method does not actually delete the message from the /home page, but
	 * deletes it from the repository, and next time /home is loaded, it reloads all
	 * messaes, sans the ones that got deleted.
	 * 
	 * @param msgID
	 *            ID of the message to be deleted
	 * @return redirects to /home.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteMessage(@RequestParam(name = "msgID") String msgID) {
		int id = Integer.parseInt(msgID);
		messageService.removeMessageById(id);
		return "redirect:/home";
	}

}
