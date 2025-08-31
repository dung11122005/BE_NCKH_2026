package com.example.nckh2026.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.nckh2026.domain.BankAccount;
import com.example.nckh2026.domain.User;
import com.example.nckh2026.repository.BankAccountRepository;


@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository=bankAccountRepository;
    }

    public List<BankAccount> handleGetBankAccountUser(User user){
        return this.bankAccountRepository.findByUser(user);
    }

    public Optional<BankAccount> handleGetBankAccountNumber(String number){
        return this.bankAccountRepository.findByAccountNumber(number);
    }
}
