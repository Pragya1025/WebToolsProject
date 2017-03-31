package com.neu.edu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="jobseekerTable")
@PrimaryKeyJoinColumn(name="personId")
public class JobSeeker extends Person{
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="skills")
	private String skills;

	
	@Column(name="category")
	private String category;
	
	public Set<Jobs> getJobs() {
		return jobs;
	}


	public void setJobs(Set<Jobs> jobs) {
		this.jobs = jobs;
	}
	@Column(name="resume")
	private String resume;

	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy ="jobSeeker")
	private Set<Jobs> jobs = new HashSet<Jobs>();
	
	


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	


	public String getResume() {
		return resume;
	}


	public void setResume(String resume) {
		this.resume = resume;
	}


	
	
	 
	 
	  public JobSeeker(String qualification, String skills,String category,String resume) {
	        this.qualification = qualification;
	        this.resume= resume;
	        this.skills= skills;
	        this.category = category;
	       
	    }

	


		public JobSeeker() {
	    }
	    
	  
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
	
}
