package com.neu.edu.pojo;

	import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



	@Entity
	@Table(name="employerTable")
	@PrimaryKeyJoinColumn(name="personId")
	public class Employer extends Person {
		
		@Column(name="company")
		private String company;
		
		@Column(name="position")
		private String position;
		

		
		@OneToMany(fetch=FetchType.EAGER,mappedBy="employer")
		private Set<Jobs> jobs = new HashSet<Jobs>();
		
     public Employer(){
	       }

		

		public Set<Jobs> getJobs() {
	   return jobs;
         }



public void setJobs(Set<Jobs> jobs) {
	this.jobs = jobs;
}



		public  Employer(String company, String position) {
	        this.company = company;
	        this.position = position;
	       // this.jobs= new HashSet<Jobs>();	
	    }

		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		

	}


