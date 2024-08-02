// package com.microservice.account.service;

// import com.microservice.account.model.PaySlip;
// import com.microservice.account.repository.PaySlipRepository;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PaySlipService {
//
//    private final PaySlipRepository payslipRepository;
//
//    @Autowired
//    public PaySlipService(PaySlipRepository payslipRepository) {
//        this.payslipRepository = payslipRepository;
//    }
//
//    public PaySlip createPayslip(PaySlip payslip) {
//        return payslipRepository.save(payslip);
//    }
//
//    public List<PaySlip> getPaySlipByEmployeeId(int employeeId) {
//        return payslipRepository.findByEmployeeId(employeeId);
//    }
//}

