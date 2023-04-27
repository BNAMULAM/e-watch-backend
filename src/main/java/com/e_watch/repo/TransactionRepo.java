package com.e_watch.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_watch.entity.Plan;
import com.e_watch.entity.Transaction;
@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {

}
