package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.JobSeeker;
import com.neu.edu.pojo.Jobs;
import com.neu.edu.pojo.Person;
import com.neu.edu.pojo.User;

public class JobSeekerDao extends DAO {
	
	public JobSeekerDao() {
		 
	}

	
	public JobSeeker createJobSeekerAccount(String qualification,String skills,String resume, String category,Person person)
            throws UserException {
        try {
            begin();
            
            
            
          JobSeeker jobseeker = new JobSeeker();
         
          jobseeker.setQualification(qualification);
          jobseeker.setSkills(skills);
          jobseeker.setCategory(category);
          jobseeker.setResume(resume);
            getSession().save(jobseeker);
            
            commit();
            return jobseeker;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create jobseeker " + username, e);
            throw new UserException("Exception while creating jobseeker: " + e.getMessage());
        }
    }
	
	 public JobSeeker get(String qualification,String skills,String resume, String category,Person person)
	            throws UserException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from JobSeeker where qualification = : qualification and  skills = : skills and resume =:resume and category =:category");
	            
	            q.setString("qualification",qualification);
	            q.setString("skills",skills);
	            q.setString("category",category);
	            q.setString("resume", resume);
	            
	            
	          JobSeeker jobseeker = (JobSeeker) q.uniqueResult();
	            commit();
	            return jobseeker;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not get jobSeeker " + category, e);
	        }
	    }


}
