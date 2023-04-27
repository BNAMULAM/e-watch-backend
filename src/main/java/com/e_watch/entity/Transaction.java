package com.e_watch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.e_watch.enums.PaymentType;

@Entity

public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private String customerId;
    private long channelId;
    private long planId;
    private double amount;
    private PaymentType paidBy;
    private String comments;
    public long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public long getChannelId() {
        return channelId;
    }
    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }
    public long getPlanId() {
        return planId;
    }
    public void setPlanId(long planId) {
        this.planId = planId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
     public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public PaymentType getPaidBy() {
        return paidBy;
    }
    public void setPaidBy(PaymentType paidBy) {
        this.paidBy = paidBy;
    }
        @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", channelId=" + channelId
                + ", planId=" + planId + ", amount=" + amount +  ", paidBy=" + paidBy
                + ", comments=" + comments + "]";
    }
        public Transaction(long transactionId, String customerId, long channelId, long planId, double amount,
            String comments, PaymentType paidBy) {
        super();
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.channelId = channelId;
        this.planId = planId;
        this.amount = amount;
      
        this.paidBy= paidBy;
        this.comments = comments;
    }
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

}
