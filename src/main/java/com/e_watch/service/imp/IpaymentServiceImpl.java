package com.e_watch.service.imp;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_watch.service.IPaymentService;
import com.e_watch.entity.Transaction;
import com.e_watch.exceptions.InvalidInputException;
import com.e_watch.repo.TransactionRepo;

@Service
public class IpaymentServiceImpl implements IPaymentService {
	 @Autowired
	    private TransactionRepo transactionRepo;

	 @Override
     public Transaction payBill(Transaction transaction) throws InvalidInputException {
          if(transaction.getAmount() == 0 || transaction.getCustomerId()==null)  {
              throw new InvalidInputException("Invalid Input");
          }
          else {
          Transaction payment = new Transaction();
          payment.setAmount(transaction.getAmount());
                payment.setCustomerId(transaction.getCustomerId());
                payment.setComments(transaction.getComments());
                payment.setChannelId(transaction.getChannelId());
          payment.setPaidBy(transaction.getPaidBy());
          payment.setPlanId(transaction.getPlanId());
             Transaction save = this.transactionRepo.save(transaction);
             return save;
          }
     }


	@Override
	public String cancelTransaction(long transactionId) {
		Transaction transaction=transactionRepo.findById(transactionId).orElseThrow();
        if(transaction==null) {
            throw new NullPointerException("No value present");
        }
        transactionRepo.delete(transaction);
        return "Cancelled";
	}

	@Override
	public List<Transaction> viewTransaction(long transactionId) {
        Transaction pay=transactionRepo.findById(transactionId).orElseThrow();
        if(pay==null) {
            throw new NullPointerException("No value present");
        }
        else {
        Transaction viewPayments=pay;
        List<Transaction> p=new ArrayList<Transaction>();
        p.add(viewPayments);
        return p;    
        }


		
	}

	
	

	

	
  
}
