package com.neu.edu.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.Dao.UserDAO;
import com.neu.edu.Exception.AdException;
import com.neu.edu.Pojo.User;

@Controller
@RequestMapping("/loginPost.htm")
public class LoginPostController {

	String username;
	UserDAO userDao = new UserDAO();

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request)
			throws Exception {

		User u;
		try {
			username = request.getParameter("username");
			u = (User) userDao.get(username);

		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
			return "Redirect";
		}
		if (u == null) {
			return "BackToHomePage";
		}

		else {
			HttpSession session = request.getSession();

			session.setAttribute("usernameVal", username);
			System.out.println("username------>" + username);

			session.setAttribute("designation", u.getType());
			System.out.println("designation------>" + u.getType());
		}

		return "Redirect";
	}
}
