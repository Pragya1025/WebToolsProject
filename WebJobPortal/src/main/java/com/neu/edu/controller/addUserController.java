package com.neu.edu.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserDao;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.JobSeeker;
import com.neu.edu.pojo.Person;
import com.neu.edu.pojo.User;

@Controller
public class addUserController {
	
	
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;
	
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@RequestMapping(value="/adduser.htm",method = RequestMethod.GET)
	protected String doSubmitAction(HttpServletRequest request,@ModelAttribute("User")User user,BindingResult result) throws Exception{
		HttpSession session = request.getSession();
		System.out.println("Inside login controller" + user.getUsername());
		session.setAttribute("username", user.getUsername());
		return "login";
	}
	
	@RequestMapping(value="/createUserDetails.htm",method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(HttpServletRequest request,@ModelAttribute("Person")Person person,BindingResult result) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		userValidator.validate(person, result);
		if (result.hasErrors()) {
			return null;
		}
	
		try {
			
			//UserDao userDao = new UserDao();
			
			if(person.getUser().getRole().equalsIgnoreCase("employer")){
				Employer e = userDao.createEmployer(person.getEmail(),person.getPhoneNumber(), person.getAddress(),person.getUser().getUsername(),person.getUser().getPassword(),person.getUser().getRole());
				HttpSession session = request.getSession();
				session.setAttribute("username", e.getUser().getUsername());
				
				mv.setViewName("addedUser");
			}
			else if(person.getUser().getRole().equalsIgnoreCase("jobSeeker")){
				System.out.println("inside JobSeeker");
				JobSeeker jobSeeker = userDao.createJobSeeker(person.getEmail(),person.getPhoneNumber(),person.getAddress(),person.getUser().getUsername(),person.getUser().getPassword(),person.getUser().getRole());
			   HttpSession session = request.getSession();
			   session.setAttribute("username", jobSeeker.getUser().getUsername());
			   mv.setViewName("jobSeekerLoginPage");
			}
			// DAO.close();
		} catch (Exception e) {
		
			System.out.println("Exception: " + e.getMessage());
		}

		return mv;
	}

	
	
	@RequestMapping(value="/createUser.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "signUp";
	}
  
	
	
	
	
	
	
	
}


