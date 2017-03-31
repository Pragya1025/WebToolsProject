package com.neu.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.Person;
import com.neu.edu.pojo.User;



@Controller
@RequestMapping("/loggedIn.htm")
public class RoleBasedController {
	
	
		@Autowired
		@Qualifier("userDao")
		UserDao userDao;

		
		@RequestMapping(method = RequestMethod.POST)
		protected ModelAndView doSubmitAction(@ModelAttribute("user") User user, Model model,Person person) throws Exception {
			
			//UserDao userDao = new UserDao();
			ModelAndView mv = new ModelAndView();
			String value  =null;
			User user1 = userDao.get(user.getUsername(), user.getPassword());
			
					if(user1.getRole().equals("employer")){
						mv.setViewName("postJob");
						return mv;
					}else if(user1.getRole().equals("job seeker")){
						mv.setViewName("SearchJobSeeker");
						return mv;
					}
					return null;
			
	}
		  
		
	}


