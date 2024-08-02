package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	List<?> findProjectByEmployeeId(int id);

//	// added new
//	List<Project> findAllByEmployeeId(int employeeId);

}
