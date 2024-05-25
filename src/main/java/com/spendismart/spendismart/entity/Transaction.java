package com.spendismart.spendismart.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String upiId;
    private String category;
    private Double amount;
    private LocalDateTime timestamp;

}
