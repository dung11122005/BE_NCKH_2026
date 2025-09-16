package com.example.nckh2026.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "transaction_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId; // transaction_id

    private Long userId;        // user_id
    private Long receiverId;    // receiver_id

    private LocalDateTime timestamp; // timestamp

    private BigDecimal transactionAmount; // transaction_amount

    private String transactionType;       // transaction_type
    private String transactionDescription;// transaction_description
    private String location;              // location

    private String deviceId;              // device_id
    private String transactionStatus;     // transaction_status

    private String timeOfDay;             // time_of_day (Morning/Afternoon/Evening/Night)
    private String dayOfWeek;             // day_of_week (Mon, Tue, ...)

    private BigDecimal accountBalanceBeforeTxn; // account_balance_before_txn

    private BigDecimal avgSentAmount;             // avg_sent_amount
    private BigDecimal deviationFromAvgSentAmount;// deviation_from_avg_sent_amount

    private BigDecimal deviationFromAvgReceivedAmount; // deviation_from_avg_received_amount
    private BigDecimal avgReceivedAmount;              // avg_received_amount

    private Integer transactionCountLast7d;           // transaction_count_last_7d
}
