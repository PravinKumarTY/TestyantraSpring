package com.tyss.springbootdemo1.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_info")
@Data//To achive getters and setters
@AllArgsConstructor//to call constructor by using all fields
@NoArgsConstructor//to call constructor with no arguments.
@Builder
public class Employee {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String name;
	@Column
	private String password;
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dob;
	@Column(unique = true, nullable = false, updatable = false)
	private String email;

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public EmployeeQualification getQualification() {
		return qualification;
	}

	public void setQualification(EmployeeQualification qualification) {
		this.qualification = qualification;
	}*/
	
}
