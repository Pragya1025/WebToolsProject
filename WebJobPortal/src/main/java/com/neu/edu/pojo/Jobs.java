package com.neu.edu.pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;




@Entity
@Table(name="jobsTable")

public class Jobs {
	@Id
	@GeneratedValue
	@Column(name="jobid")
	private int jobid;
	
	@Column(name="jobtitle")
	private String jobtitle;
	
	@Column(name="jobdescription")
	private String jobdescription;

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	
	private Employer employer;
	
	@Column(name="salary")
	private String salary;
	
	@Column(name="skills")
	private String skills;
	
	@Column(name="date")
	private String date;
	
	@Column(name="location")
	private String location;
	

	
 @ManyToMany(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
 private Set<JobSeeker> jobSeeker = new HashSet<JobSeeker>();
	 
	 public Jobs(int jobid, String jobTitle, String jobdescription,String salary,String skills,String date,String location) {
	        this.jobid = jobid;
	        this.jobtitle = jobTitle;
	        this.jobdescription = jobdescription;
	        this.salary=salary;
	        this.skills= skills;
	        this.date= date;
	        this.location=location;
			this.employer= new Employer (location, skills);
	    }


	public Set<JobSeeker> getJobSeeker() {
		return jobSeeker;
	}


	public void setJobSeeker(Set<JobSeeker> jobSeeker) {
		this.jobSeeker = jobSeeker;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Jobs() {
	    }

	
	

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	
	
	
}

