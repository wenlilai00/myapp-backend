package com.microservice.account.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	private String title; 
	
	private LocalDate startDate; 
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	private LocalDate endDate; 
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@ManyToOne
	@JoinColumn(name="manager_id")
	private Manager manager;
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public int getManagerId() {
//		return getManagerId();
//	}
//
//	public void setManagerId(int managerId) {
//	}
//
//	public int getEmployeeId() {
//		return getEmployeeId();
//	}
//
//	public void setEmployeeId(int employeeId) {
//	} 
	
	
}
