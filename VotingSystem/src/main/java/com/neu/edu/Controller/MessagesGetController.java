package com.neu.edu.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.neu.edu.Pojo.Message;
import com.neu.edu.Pojo.User;

@Controller
public class MessagesGetController {

	String action;

	@RequestMapping(value = "/messagesGet.htm", method = RequestMethod.GET)
	public String displayMessages(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) {

		action = request.getParameter("username");

		RestTemplate restTemplate = new RestTemplate();
		Message msg = restTemplate.getForObject("http://localhost:8080/messenger/webapi/messages/", Message.class);

		request.setAttribute("message", msg);
		return "Messages";
	}

}
