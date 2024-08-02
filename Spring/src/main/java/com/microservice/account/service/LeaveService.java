package com.microservice.account.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Leave;
import com.microservice.account.repository.LeaveRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;
	
	public Leave postLeave(Leave leave) {
		return leaveRepository.save(leave);
		
	}

	public List<Leave> getAllLeaves(String username) {
		return leaveRepository.getAllLeaves(username);
	}

	public Leave getLeave(int leaveId) {
		 
		return leaveRepository.findById(leaveId).get();
	}

	public List<Leave> getAllLeavesManager(String managerUsername) {
		
		return leaveRepository.getAllLeavesManager(managerUsername);
	}

}

