package com.neu.edu.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.Pojo.User;

@Controller
// @RequestMapping("/registrationGet.htm")
public class RegistrationGetController {
	String category;
	String subCategory;
	String requestInfo;
	String additionalInfo;

	@RequestMapping(value = "/registrationGet.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) {

		return "registration";
	}

}
