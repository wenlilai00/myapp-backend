//package com.microservice.account.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.microservice.account.model.PaySlip;
//import com.microservice.account.model.Task;
//import com.microservice.account.repository.PaySlipRepository;
//import com.microservice.account.service.PaySlipService;
//
//@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
//public class PaySlipController {
//	
//	private PaySlipService payslipService;
//
//	@Autowired
//    public PaySlipRepository paySlipRepository;
//
//	package com.microservice.account.controller;
//
//	import java.util.List;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.http.ResponseEntity;
//	import org.springframework.web.bind.annotation.CrossOrigin;
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.PathVariable;
//	import org.springframework.web.bind.annotation.PostMapping;
//	import org.springframework.web.bind.annotation.RequestBody;
//	import org.springframework.web.bind.annotation.RestController;
//
//	import com.microservice.account.model.PaySlip;
//	import com.microservice.account.service.PaySlipService;
//
//	@RestController
//	@CrossOrigin(origins = {"http://localhost:3000"})
//	public class PaySlipController {
//		
//		private PaySlipService payslipService;
//
//		@Autowired
//	    public PaySlipController(PaySlipService payslipService) {
//	        this.payslipService = payslipService;
//	    }
//
//		@PostMapping("/api/payslip/employee/{eid}")
//		public void sendPayslip(@PathVariable("eid") int eid, @RequestBody Payslip payslip) {
//			paySlipService.sendPayslip(eid,payslip);
//		}
//		
//		@GetMapping("/api/payslip/{eid}")
//		public List<Task> getAllTask(@PathVariable("eid") int eid){
//			return taskService.getAllTask(eid)
//						.stream()
//						.filter(t->t.isArchived() == false)
//						.collect(Collectors.toList());
//		}
//	}
//
//}
