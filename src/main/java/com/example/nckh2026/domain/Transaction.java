package com.example.nckh2026.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Người gửi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    // Người nhận (có thể null nếu chuyển ra ngoài)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    // Bank account của người gửi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_bank_id")
    private BankAccount senderBank;

    // Bank account của người nhận
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_bank_id")
    private BankAccount receiverBank;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(length = 10, nullable = false)
    private String currency;

    @Column(name = "transaction_type", length = 20, nullable = false)
    private String transactionType; // chuyển tiền, nạp, rút

    @Column(length = 20, nullable = false)
    private String status; // pending, success, failed

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "device_info", length = 255)
    private String deviceInfo;
}
