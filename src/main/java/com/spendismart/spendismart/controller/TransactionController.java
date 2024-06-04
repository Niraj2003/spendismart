package com.spendismart.spendismart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spendismart.spendismart.dto.TransactionDto;
import com.spendismart.spendismart.entity.Transaction;
import com.spendismart.spendismart.repository.TransactionRepository;
import com.spendismart.spendismart.repository.UserRepository;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/id/{userId}")
    public List<Transaction> getTransactionsForUser(@PathVariable Long userId, @CookieValue(name = "token") String token) {
        if(token == null) {
            return null;
        }
        return transactionRepository.findByUserId(userId);
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody TransactionDto transactionDto, @CookieValue(name = "token") String token) {
        if(token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println("Token: " + token);
        Transaction transaction = Transaction.builder()
                .user(userRepository.findByUsername(token))
                .category(transactionDto.getCategory())
                .amount(transactionDto.getAmount())
                .timestamp(transactionDto.getTimestamp())
                .build();
        Transaction savedTransaction = transactionRepository.save(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }
}
