package com.microservice.account.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.LeaveStatus;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Leave;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.LeaveService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class LeaveController {

	@Autowired
	private LeaveService leaveService;
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/api/leave/post")
	public void postLeave(Principal principal, @RequestBody Leave leave) {
		String username = principal.getName();
		/* Fetch Employee on the based on username */
		Employee employee = employeeService.getEmployeeByUsername(username); 
		
		/* Attach the employee to Leave */
		leave.setEmployee(employee);
		leave.setStatus(LeaveStatus.PENDING);
		/*Save the Leave */
		leaveService.postLeave(leave);
	}
	@GetMapping("/api/leave/all")
	public List<Leave> getAllLeaves(Principal principal){
		String username = principal.getName();
		
		List<Leave> list = leaveService.getAllLeaves(username)
				.stream()
				.filter(l->l.isArchive() == false)
				.collect(Collectors.toList());
		
		return list; 		
	}
	
	@GetMapping("/api/manager/leave/all")
	public List<Leave> getAllLeavesForManager(Principal principal){
		String username = principal.getName();
		
		List<Leave> list = leaveService.getAllLeavesManager(username)
				.stream()
				.filter(l->l.isArchive() == false)
				.collect(Collectors.toList());
		
		return list; 		
	}
	
	@GetMapping("/api/leave/update/{leaveId}/{status}")
	public Leave updateLeaveStatus(Principal principal, 
								  @PathVariable("leaveId") int leaveId  ,
								  @PathVariable("status") LeaveStatus status) {
		Leave leave = leaveService.getLeave(leaveId);
		leave.setStatus(status);
		return leaveService.postLeave(leave);
	}
	
	@GetMapping("/api/leave/archive/{leaveId}")
	public Leave updateLeaveArchive(  @PathVariable("leaveId") int leaveId ) {
		Leave leave = leaveService.getLeave(leaveId);
		leave.setArchive(true);
		return leaveService.postLeave(leave);
	}
	
	
}
