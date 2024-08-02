package com.microservice.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.dto.ResponseDto;
import com.microservice.account.exception.ResourceNotFoundException;
import com.microservice.account.model.Project;
import com.microservice.account.model.Region;
import com.microservice.account.service.ProjectService;
import com.microservice.account.service.RegionService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProjectController {

	@Autowired
	private RegionService regionService;
	
	@Autowired
	private ProjectService projectService;
	
	 @PostMapping("/api/project/add/{employeeId}/{managerId}")
	    public ResponseEntity<Project> addProject(@RequestBody Project project, 
	    		@PathVariable("employeeId") int employeeId,
	    		@PathVariable("managerId") int managerId) {
	        Project newProject = projectService.postProject(project, employeeId, managerId);
	        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
	    }
	
	 @GetMapping("/api/project/allproject")
	    public ResponseEntity<List<Project>> getAllProjects() {
	        List<Project> projects = projectService.getAllProjects();
	        return new ResponseEntity<>(projects, HttpStatus.OK);
	    }
	 
	 //newly added
//	 @GetMapping("/api/project/employee/{employeeId}")
//		public List<Project> getProjectsByEmployeeId(@PathVariable int employeeId){
//			return projectService.getProjectByEmployeeId(employeeId);
//		}
	 
//	@PostMapping("/api/project/add/{regionId}")
//	public ResponseEntity<?> postProject(@PathVariable("regionId") int regionId,  
//			@RequestBody Project project) {
		
		/* Fetch region obj based on regionid */
		
//		Region region = null; 
//		try {
//			region  = regionService.getRegionById(regionId);
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity
//					 .badRequest()
//					 .body(new ResponseDto(e.getMessage(), "400"));
//		}
		/* Attach region to project */
//		project.setRegion(region);
		
		/* Save project */
//		project = projectService.postProject(project);
//		return ResponseEntity.ok().body(project); 
		
		// get employee id based on assigned project to id
	}
	
//	@PutMapping("/api/project/edit/{id}")
//    public ResponseEntity<?> editProject(@PathVariable("id") int id, 
//                                         @RequestBody Project projectNew) {
//        try {
//            Project projectOld = projectService.getProjectById(id);
//            /* update fields */
//            projectOld.setTitle(projectNew.getTitle());
//            projectOld.setManagerId(projectNew.getManagerId());
//            projectOld.setEmployeeId(projectNew.getEmployeeId());
//            /* save projectOld */
//            projectOld = projectService.saveProject(projectOld);
//            
//            return ResponseEntity.ok().body(projectOld);
//        } catch (ResourceNotFoundException e) {
//            ResponseDto dto = new ResponseDto(e.getMessage(), "400");
//            return ResponseEntity.badRequest().body(dto);
//        }
//    }
//
//    @DeleteMapping("/api/project/delete/{id}")
//    public ResponseEntity<?> deleteProject(@PathVariable("id") int id) {
//        projectService.deleteProject(id);
//		return ResponseEntity.ok().body("Project deleted.");
//    }
//}