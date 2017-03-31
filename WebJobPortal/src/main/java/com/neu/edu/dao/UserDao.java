package com.neu.edu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.JobSeeker;
import com.neu.edu.pojo.Person;
import com.neu.edu.pojo.User;


public class UserDao extends DAO {

	public UserDao() {

	}
	
	
	public Employer getUser(String username) throws UserException
	
	{
		
		System.out.println("inside user dao"+username);
		try{
			begin();
			Query query = getSession().createQuery("from User where username=:username");
			query.setString("username",username);
			User user = (User)query.uniqueResult();
			query = getSession().createQuery("from Employer where personId=:userId");
			query.setLong("userId",user.getUserId());
			Employer e = (Employer)query.uniqueResult();
			commit();
			return e;
			
			
		}
		catch(HibernateException e)
		{
			rollback();
			throw new UserException("Could not find employer" + e.getMessage());
		}
	
		
	}
	
public JobSeeker getJobSeeker(String username) throws UserException
	
	{
		
		
		try{
			begin();
			Query query = getSession().createQuery("from User where username=:username");
			query.setString("username",username);
			User user = (User)query.uniqueResult();
			query = getSession().createQuery("from JobSeeker where personId=:userId");
			query.setLong("userId",user.getUserId());
			JobSeeker j = (JobSeeker)query.uniqueResult();
			commit();
			return j;
			
			
		}
		catch(HibernateException e)
		{
			rollback();
			throw new UserException("Could not find employer" + e.getMessage());
		}
	
		
	}
	
	
	
public User validateUserAccount(String username,String password) throws UserException
	
	{
		try{
			begin();
			Query query = getSession().createQuery("from User where username=:username and password=:password");
			query.setString("username",username);
			query.setString("password",password);
			User user = (User)query.uniqueResult();
			commit();
			return user;
			
			
		}
		catch(HibernateException e)
		{
			rollback();
			throw new UserException("Could not find employer" + e.getMessage());
		}
		finally{
			close();
		}
		
	}
	
	
	
	

	public User createUserAccount(String username, String password, String role, Person person) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			user.setPerson(person);
			//person.setUser(user);
			getSession().save(user);

			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void createPerson(String email, String phoneNumber, String address, User user1) {
		// TODO Auto-generated method stub
		try {
			begin();
			Employer employer = new Employer();
	
			User user = new User();
			user.setUsername("Sa");
			user.setPassword("samtest");
			user.setRole("employer");
			
			employer.setEmail(email);
			employer.setAddress(address);
			employer.setPhoneNumber(phoneNumber);
//			person.setEmail(email);
//			person.setAddress(address);
//			person.setPhoneNumber(phoneNumber);
//			
		//	person.setUser(user1);
			//employer.setUser(user);
			employer.setPosition("hello");
			employer.setCompany("TCS");
			getSession().save(employer);
			commit();

		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not create person");
			System.out.print(e.getMessage());
		}
		
		

	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	
	
	public Employer createEmployer(String email, String phoneNumber,String address,String username,String password,String role)
	{
		try {
			begin();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			
			Employer employer = new Employer();
			employer.setAddress(address);
			employer.setEmail(email);
			employer.setPhoneNumber(phoneNumber);
			employer.setUser(user);
			user.setPerson(employer);
			getSession().save(employer);
			
			commit();
			return employer;
		}
		catch(HibernateException e)
		{
			rollback();
			System.out.println(e.getMessage());
			
		}
		return null;
		
	}
	
	
	
	public JobSeeker createJobSeeker(String email, String phoneNumber,String address,String username,String password,String role){
		try{
			begin();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			
			JobSeeker jobSeeker = new JobSeeker();
			jobSeeker.setAddress(address);
			jobSeeker.setEmail(email);
			jobSeeker.setPhoneNumber(phoneNumber);
			jobSeeker.setUser(user);
			user.setPerson(jobSeeker);
			getSession().save(jobSeeker);
			commit();
			return jobSeeker;
			
			
		}
		catch(HibernateException e){
			rollback();
			System.out.println(e.getMessage());
		}
		return null;
	}

}
