package com.neu.edu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="person")
@Inheritance(strategy= InheritanceType.JOINED)
public class Person {
	
public Person(){
	
	
}
		@Id
		@GeneratedValue
		@Column(name="personId",unique=true,nullable=false)
		private long personId;
		
		
		@Column(name="email")
		private String email;
		
		@OneToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL, mappedBy="person")
		private User user;
		

		@Column(name="phonenumber")
		private String phoneNumber;
		
		@Column(name="address")
		private String address;
		
//		@Column(name="role")
//		private String role;

		public long getPersonId() {
			return personId;
		}

		public void setPersonId(long personId) {
			this.personId = personId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

//		public String getRole() {
//			return role;
//		}
//
//		public void setRole(String role) {
//			this.role = role;
//		}
	


}
