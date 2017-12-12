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

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	private Message msg;
	private AtomicInteger count = new AtomicInteger(0);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String messageForm() {
		return "messageform";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
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
		return "home";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String handleDeleteUser(@RequestParam(name="msgID")String msgID) {
	    int id = Integer.parseInt(msgID);
		messageService.removeMessageById(id);
	    return "redirect:/home";
	}


}
