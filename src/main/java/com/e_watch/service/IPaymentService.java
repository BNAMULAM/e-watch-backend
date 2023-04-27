package com.e_watch.service;


import java.util.List;

import com.e_watch.entity.Transaction;
import com.e_watch.exceptions.InvalidInputException;

public interface IPaymentService {
	public Transaction payBill(Transaction transaction) throws InvalidInputException;
   public String cancelTransaction(long transactionId);
   public List<Transaction> viewTransaction(long transactionId);

}
