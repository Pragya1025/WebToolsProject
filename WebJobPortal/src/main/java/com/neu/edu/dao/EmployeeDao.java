package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.Person;

public class EmployeeDao extends DAO {
	
	
	public EmployeeDao() {
    }
	
	
	 public Employer createEmployerAccount(String company, String position,String employerid,Person person)
	            throws UserException {
	        try {
	            begin();
	           
	            
	            
	           Employer employer = new Employer(company, employerid);
	           employer.setCompany(company);
	           employer.setPosition(position);
	       
	           
	           getSession().save(employer);
	            
	            commit();
	            return employer;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create employee " + username, e);
	            throw new UserException("Exception while creating employee: " + e.getMessage());
	        }
	    }
	 
	 public Employer get(String company, String position,String employerid)
	            throws UserException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Employer where company = :company and position = :position and employerid = :employerid ");
	            q.setString("company", company);
	            q.setString("position", position);
	            q.setString("employerid", employerid);
	            
	            
	           Employer employer = (Employer) q.uniqueResult();
	            commit();
	            return employer;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not get employer " + employerid, e);
	        }
	    }

}
