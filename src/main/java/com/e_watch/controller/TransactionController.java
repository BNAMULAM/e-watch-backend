package com.e_watch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_watch.entity.Transaction;
import com.e_watch.exceptions.InvalidInputException;
import com.e_watch.service.IPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
    private IPaymentService iPaymentServiceImpl;
	
    @PostMapping("/addPayment")
    public Transaction payBill(@RequestBody Transaction transaction) throws InvalidInputException {
        Transaction payment=iPaymentServiceImpl.payBill(transaction);
        return payment;
    }
	
    @DeleteMapping("/cancelTransaction/{id}")
    public String cancelTransaction(@PathVariable("id") Long transactionId) {
        String message = iPaymentServiceImpl.cancelTransaction(transactionId);
        return message;
    }
	
    @GetMapping("/viewTransaction/{id}")
	public List<Transaction> viewTransaction(@PathVariable("id")Long transactionId) {
        List<Transaction> viewPayments = iPaymentServiceImpl.viewTransaction(transactionId);
        return viewPayments;
    }

}
