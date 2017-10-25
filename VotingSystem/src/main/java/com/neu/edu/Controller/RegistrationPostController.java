package com.neu.edu.Controller;

import javax.servlet.http.HttpServletRequest;

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
public class RegistrationPostController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value ="/registrationPost.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
		validator.validate(user, result);
		System.out.println("user-->" + user);
		System.out.println("Result-->" + result);

		
		if (result.hasErrors()) {
			System.out.println(result.hasErrors());
			return "Error";
		}

		try {
			UserDAO userDao = new UserDAO();
			userDao.create(user.getUsername(), user.getPassword(),user.getEmail(), user.getFullname());
			User u = userDao.get(user.getUsername());
			request.getSession().setAttribute("usernameVal",u.getUsername());			
			String designation = u.getType();
			System.out.println("designation" + designation);
			request.getSession().setAttribute("designation", designation);

			return "Redirect";
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
			return "Error";
		}

		
	}
}
