package com.entity;

import java.time.LocalDateTime;

public class Employee {
	
	private Long id;
	private String name;
	private LocalDateTime dateOfBirth;
	private String email;
	private Long mobile;

	public Employee() {
		super();
	}

	public Employee(Long id, String name, LocalDateTime dateOfBirth, String email, Long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobile = mobile;
	}

	public Employee(String name, LocalDateTime dateOfBirth, String email, Long mobile) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

}
