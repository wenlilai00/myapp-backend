//package com.microservice.account.controller;
//
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.microservice.account.dto.ResponseDto;
//import com.microservice.account.exception.ResourceNotFoundException;
//import com.microservice.account.model.Employee;
//import com.microservice.account.model.Project;
//import com.microservice.account.model.Manager;
//import com.microservice.account.service.EmployeeService;
//import com.microservice.account.service.ProjectService;
//import com.microservice.account.service.ManagerService;
//
//@RestController
//@RequestMapping("/api/hr/project")
//public class HRProjectController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private ProjectService projectService;
//
//    @Autowired
//    private ManagerService managerService;
//
//    @PostMapping("/assign/{managerId}/{projectId}")
//    public ResponseEntity<?> assignProjectToManagerAndEmployees(
//            @PathVariable("managerId") Integer managerId,
//            @PathVariable("projectId") Integer projectId,
//            @RequestBody Set<Integer> employeeIds) {
//        
//        Manager manager;
//        try {
//            manager = managerService.getManagerById(managerId);
//        } catch (ResourceNotFoundException e) {
//            return ResponseEntity.badRequest().body(new ResponseDto(e.getMessage(), "400"));
//        }
//
//        Project project;
//        try {
//            project = projectService.getProjectById(projectId);
//        } catch (ResourceNotFoundException e) {
//            return ResponseEntity.badRequest().body(new ResponseDto(e.getMessage(), "400"));
//        }
//
//        Set<Employee> employees;
//        try {
//            employees = employeeService.getEmployeesByIds(employeeIds);
//        } catch (ResourceNotFoundException e) {
//            return ResponseEntity.badRequest().body(new ResponseDto(e.getMessage(), "400"));
//        }
//
//        project.setManager(manager);
//        project.setEmployees(employees);
//
//        Project updatedProject = projectService.updateProject(project);
//        return ResponseEntity.ok(updatedProject);
//    }
//}

