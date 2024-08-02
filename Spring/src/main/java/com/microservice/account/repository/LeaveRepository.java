package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservice.account.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{

	@Query("select l from Leave l "
			+ " JOIN l.employee e "
			+ " JOIN e.userInfo u "
			+ " where u.username=?1")
	List<Leave> getAllLeaves(String username);

	@Query("select l from Leave l "
			+ " JOIN l.employee e "
			+ " JOIN e.manager m "
			+ " JOIN m.userInfo u "
			+ " where u.username=?1")
	List<Leave> getAllLeavesManager(String managerUsername);

}
