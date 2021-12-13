package com.example.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="user_roles", uniqueConstraints=
	@UniqueConstraint(columnNames={"role"})
)
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name="role")
	private String role;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_on")
	private Timestamp created_on;
	
	@Column(name="updated_by")
	private String updated_by;
	
	@Column(name="updated_on")
	private Timestamp updated_on;
	
	public UserRoles() {}

	public UserRoles(String role) {
		super();
		this.role = role;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	
	
}
