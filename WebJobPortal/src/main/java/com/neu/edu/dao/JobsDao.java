package com.neu.edu.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.JobSeeker;
import com.neu.edu.pojo.Jobs;
import com.neu.edu.pojo.User;



public class JobsDao extends DAO {
	
	public JobsDao() {
		 
	}
	
	
	public Jobs createJobs(String jobTitle, String jobDescription,String jobLocation,String jobSalary, String skills,Employer e)
            throws UserException {
        try {
            begin(); 
            
            
            
         Jobs jobs= new Jobs();
     
          jobs.setJobtitle(jobTitle);
          jobs.setJobdescription(jobDescription);
          jobs.setSalary(jobSalary);
          jobs.setSkills(skills);
        
          jobs.setLocation(jobLocation);
          jobs.setEmployer(e);
          e.getJobs().add(jobs);
            getSession().save(jobs);
            
            commit();
            return jobs;
        } catch (HibernateException exception) {
            rollback();
            //throw new AdException("Could not create jobseeker " + username, e);
            throw new UserException("Exception while creating jobs: " + exception.getMessage());
        }
    }

	
	public Jobs get(String jobid, String jobtitle,String jobdescription,String salary, String skills, Date date, String location)
            throws UserException {
        try {
            begin();
            Query q = getSession().createQuery("from Jobs where jobid = :jobid and jobtitle = :jobtitle and jobdescription = :jobdescription and salary = :salary and skills= :skills and date= :date and location= :location and employer = :employer  ");
            q.setString("jobid", jobid);
            q.setString("jobtitle", jobtitle);
            q.setString("jobdescription", jobdescription);
            q.setString("skills", skills);
            q.setDate("date", date);
            
           Jobs job = (Jobs) q.uniqueResult();
            commit();
            return job;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not get job " + jobtitle, e);
        }
    }

	 public List<Jobs> getJobList() throws UserException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Jobs");
	            List<Jobs> list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not list the Jobs", e);
	        }
	    }
	 
	 public List<Jobs> searchJobs(String searchBy, String searchValue) throws UserException {
	        try {
	            begin();
	            List<Jobs> job   = new ArrayList<Jobs>();
	            if(searchBy.equals("jobTitle")){
	            	
	                
		            Query q = getSession().createQuery("from Jobs where jobtitle=:jobTitle");
		            q.setString("jobTitle", searchValue);
		            job = q.list();
		            
	            }else if(searchBy.equals("jobId")){
	            	 
	            Long jobId = 	Long.parseLong(searchValue);
	            
		            Query q = getSession().createQuery("from Jobs where jobid=:jobid");
		            q.setLong("jobid",jobId);
		            job = q.list();
	            	
	            }else if(searchBy.equals("jobLocation")){
	            	
	            	   Query q = getSession().createQuery("from Jobs where location =:location");
			            q.setString("location",searchValue);
			            job = q.list();
		            	
	            }else{
	            	
	            	job = null;
	            }
	     
	   
	            return job;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not list the Jobs", e);
	        }
	    }
	 
	 
	 public Jobs getJob(int id) throws UserException
	 {
		 try{
			 
			 begin();
			 Query query =getSession().createQuery("from Jobs where jobid=:id");
			 query.setInteger("id", id);
			 Jobs job = (Jobs)query.uniqueResult();
			System.out.println("Inside job " + job.getJobid());
			 commit();
			 return job;
			 
		 }
		 catch(HibernateException e)
		 {
			 rollback();
			 throw new UserException("Could not find job: " + e.getMessage());
		 }
		
		 
		 
	 }
	 
	 public void applyJob(Jobs job,JobSeeker jobSeeker)throws UserException
	 {
		try{
			
			begin();
			job.getJobSeeker().add(jobSeeker);
			getSession().save(job);
			commit();
		
		}
		
		 catch(HibernateException e)
		 {
			 rollback();
			 throw new UserException("Could not find job: " + e.getMessage());
		 }
		 finally{
			 close();
		 }
		 
	 }

}
