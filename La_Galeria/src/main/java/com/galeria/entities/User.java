package com.galeria.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

	@Entity
	@Table(name="users")
	public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="user_id")
		private Integer userID;
		
		@Column(name="user_name")
		private String userName;
		
		@Column(name="user_passwd")
		private String userPasswd;
		
		@Column(name="user_email")
		private String userEmail;
		
		@ElementCollection(fetch= FetchType.EAGER)
		@CollectionTable(name="roles",joinColumns = @JoinColumn(name="user_id"))
		@Column(name="user_role")
		private List<String> user_role;

		public User(Integer userID, String userName, String userPasswd, String userEmail, List<String> user_role) {
			super();
			this.userID = userID;
			this.userName = userName;
			this.userPasswd = userPasswd;
			this.userEmail = userEmail;
			this.user_role = user_role;
		}

		public User(String userName, String userPasswd, String userEmail) {
			super();
			this.userName = userName;
			this.userPasswd = userPasswd;
			this.userEmail = userEmail;
		}

		public User() {
			super();
		}

		

		public Integer getUserID() {
			return userID;
		}

		public void setUserID(Integer userID) {
			this.userID = userID;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPasswd() {
			return userPasswd;
		}

		public void setUserPasswd(String userPasswd) {
			this.userPasswd = userPasswd;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public List<String> getUser_role() {
			return user_role;
		}

		public void setUser_role(List<String> user_role) {
			this.user_role = user_role;
		}
		
	}

