package com.neu.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.JobsDao;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Jobs;

@Controller
public class SearchController {

	
	@Autowired
	@Qualifier("jobsDao")
	JobsDao jobDao;
	
	
	@RequestMapping(value="searchAllJob.htm",method = RequestMethod.GET)
	public ModelAndView doGetAllJobs() throws UserException{
		
		ModelAndView mv = new ModelAndView();
		
		
		//JobsDao jobDao = new JobsDao();
		
		
		List<Jobs> job  = jobDao.getJobList();
		mv.addObject("jobs",job);
		mv.setViewName("Apply");
		
		return mv;
		
	}
	
	
	//searchJobByValue.htm
	@RequestMapping(value="searchJobByValue.htm*",method = RequestMethod.POST)
	public ModelAndView doSearchJob(HttpServletRequest request) throws UserException{
		//name="searchBy" value="jobId"
		String searchBy = request.getParameter("searchBy");
		String searchValue = request.getParameter("searchValue");
		System.out.println("searchBy "+searchBy+"jsndjkasndjkaskjdkasd"+"searchValue"+searchValue);
		
		//System.out.println(x);
		ModelAndView mv = new ModelAndView();
		
		
		//JobsDao jobDao = new JobsDao();
		
		List<Jobs> job  = jobDao.searchJobs(searchBy,searchValue);
		
		
		mv.addObject("jobs",job);
		mv.setViewName("Apply");
		return mv;
		
	}
	
}
