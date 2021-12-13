package com.example.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import lombok.Data;

//@Data
@Entity
@Table(name="users" , uniqueConstraints=
	@UniqueConstraint(columnNames={"user_id"})
)
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="role")
	private int role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id")
	private UserRoles user_roles;
	
	@Column(name="name")
	private String name;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_on")
	private Timestamp created_on;
	
	@Column(name="updated_by")
	private String updated_by;
	
	@Column(name="updated_on")
	private Timestamp updated_on;
	
	public Users() {}

	public Users(int role, String user_id, String name) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.role=role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Timestamp getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Timestamp updated_on) {
		this.updated_on = updated_on;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public UserRoles getUser_roles() {
		return user_roles;
	}

	public void setUser_roles(UserRoles user_roles) {
		this.user_roles = user_roles;
	}

	

	
	
}
