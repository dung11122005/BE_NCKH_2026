package com.example.nckh2026.domain.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResAccountBankDTO {
    
    private String bankName;

    private String accountNumber;

    private String accountHolder;


    public ResAccountBankDTO(String bankName, String accountNumber, String accountHolder) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }
}
