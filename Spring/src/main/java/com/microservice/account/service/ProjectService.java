package com.microservice.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.exception.ResourceNotFoundException;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Manager;
import com.microservice.account.model.Project;
import com.microservice.account.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ManagerService managerService;
	
	public Project getProjectById(int projectId) throws ResourceNotFoundException {
		Optional<Project> optional = projectRepository.findById(projectId);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("Project Id Invalid...");
		return optional.get();
	}

	public Project postProject(Project project, int employeeId, int managerId) {
		Employee employee = null;
		Manager manager = null;
		
		employee = employeeService.findEmployeeById(employeeId);
		manager = managerService.findManagerById(managerId);
		project.setEmployee(employee);
		project.setManager(manager);
		return projectRepository.save(project);
	}

	 public Project saveProject(Project project) {
	        return projectRepository.save(project);
	    }

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}
	
	// added new
//	public List<Project> getProjectByEmployeeId(int employeeId) {
//		return projectRepository.findAllByEmployeeId(employeeId);
//	}

    public void deleteProject(int id) throws ResourceNotFoundException {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }

	public List<?> getProjectByEmployee(int id) {
		return projectRepository.findProjectByEmployeeId(id);
	}

}

