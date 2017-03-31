package com.neu.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.User;



@Controller
public class SignInController {
	
//	@Autowired
//	@Qualifier("personValidator")
//	PersonValidator validator;
//@InitBinder
//	
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@RequestMapping(value="/signIn.htm",method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(HttpServletRequest request) throws Exception{
		String username =request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
//		System.out.println("Inside login controller" + user.getUsername());
//		session.setAttribute("username", user.getUsername());
//		
		session.setAttribute("username", username);
		ModelAndView mv  = new ModelAndView();
		//UserDao userDao = new UserDao();
		User user1  = userDao.validateUserAccount(username, password);
		
		if(user1.getRole().equals("employer")){
			mv.addObject(user1);
			mv.setViewName("addedUser");
			
		}else if(user1.getRole().equals("jobSeeker")){
			mv.addObject(user1);
			mv.setViewName("jobSeekerLoginPage");
			
		}
		
		return mv;
		
		
		
		
		
		
	}
	
	
}
