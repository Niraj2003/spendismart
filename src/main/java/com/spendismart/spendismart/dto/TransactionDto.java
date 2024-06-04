package com.spendismart.spendismart.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDto {

    private String category;
    private Double amount;

    private LocalDateTime timestamp;

    public TransactionDto() {
        this.timestamp = LocalDateTime.now();
    }

}
