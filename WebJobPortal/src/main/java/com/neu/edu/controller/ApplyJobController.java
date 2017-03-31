package com.neu.edu.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.edu.dao.JobsDao;
import com.neu.edu.dao.UserDao;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.JobSeeker;
import com.neu.edu.pojo.Jobs;



@Controller
@RequestMapping("/ApplyNewJob.htm")
public class ApplyJobController {
	
	
	@Autowired
	@Qualifier("jobsDao")
	JobsDao jobDao;
	
	
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String doSubmitAction(HttpServletRequest request){
		

		try{
			String id = request.getParameter("id");
		
			int jobId=0;
			if(id!=null && !id.isEmpty())
				jobId = Integer.parseInt(id.trim());
			
			
			System.out.println(jobId);
		
			Jobs job = jobDao.getJob(jobId);

			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("username");
			
		
			//UserDao userDao = new UserDao();
			JobSeeker jobSeeker = userDao.getJobSeeker(username);
			System.out.println(jobSeeker.getPersonId());
			jobDao.applyJob(job,jobSeeker);
			
			return "AppliedSuccess";
		
		}
		catch(UserException e)
		{
			System.out.println(e.getMessage());
		}
		return "";
	}
}
	  


		
		
		
		
		
	
