package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="user")
public class User {
	
	public User()
	{
		
	}
	
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="person"))
		
	@Id
@GeneratedValue(generator="generator")
@Column(name="userId",unique=true, nullable=false)

		private long userId;

		
		@Column(name="username",unique=true, nullable=false)
		private String username;
		
		@Column(name="password")
		private String password;
		
		
		@Column(name="role")
		private String role;

		  @OneToOne
		  @PrimaryKeyJoinColumn
		private Person person;

		public Person getPerson() {
			return person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}



		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

	




}
