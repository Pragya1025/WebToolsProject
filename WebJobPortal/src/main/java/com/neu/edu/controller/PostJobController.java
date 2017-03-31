package com.neu.edu.controller;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.EmployeeDao;
import com.neu.edu.dao.JobsDao;
import com.neu.edu.dao.UserDao;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.Jobs;
import com.neu.edu.pojo.Person;
import com.neu.edu.pojo.User;


@Controller
@RequestMapping("/postJob.htm")
public class PostJobController {
	
	
	@Autowired
	@Qualifier("jobValidator")
	JobValidator jobValidator;
	
	@Autowired
	@Qualifier("jobsDao")
	JobsDao jobsDao;
	
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	private void initBinder(WebDataBinder binder) {
        binder.setValidator(jobValidator);
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest request,@ModelAttribute("jobs")Jobs jobs,BindingResult result) throws Exception{
		
		jobValidator.validate(jobs, result);
		if (result.hasErrors()) {
			return "posted";
		}
		
		
		try {
		//JobsDao jobsDao= new JobsDao();	
		
		HttpSession session = request.getSession();
		
		String username = (String)session.getAttribute("username");	
		//UserDao userDao = new UserDao();
		Employer e = userDao.getUser(username);
		System.out.println("inside post job controller"+e.getPersonId());
		Jobs job1 = jobsDao.createJobs(jobs.getJobtitle(),jobs.getJobdescription(),jobs.getLocation(),jobs.getSalary(),jobs.getSkills(),e);
		//jobsDao.save(job1);
		
		} catch (UserException e) {
			//UserException
			System.out.println("Exception: " + e.getMessage());
		}
		
		return "posted";
		}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("jobs") Jobs jobs, BindingResult result) {

		return "postJob";
	}
	
}
	


