package com.spendismart.spendismart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spendismart.spendismart.entity.Transaction;
import com.spendismart.spendismart.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByUpiId(String upiId) {
        return transactionRepository.findByUpiId(upiId);
    }

    public Transaction saveTransaction(Transaction transaction) {
        // logic for categorization
        return transactionRepository.save(transaction);
    }
}
