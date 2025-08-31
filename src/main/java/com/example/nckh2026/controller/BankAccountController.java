package com.example.nckh2026.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nckh2026.domain.BankAccount;
import com.example.nckh2026.domain.User;
import com.example.nckh2026.domain.response.ResAccountBankDTO;
import com.example.nckh2026.service.BankAccountService;
import com.example.nckh2026.service.UserService;





@RestController
@RequestMapping("/api/v1")
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final UserService userService;


    public BankAccountController(BankAccountService bankAccountService, UserService userService){
        this.bankAccountService=bankAccountService;
        this.userService=userService;
    }

    @GetMapping("/bankaccount")
        public ResponseEntity<List<ResAccountBankDTO>> getBankAccount() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = this.userService.handleGetUserByUsername(username);
        
        List<BankAccount> accounts = this.bankAccountService.handleGetBankAccountUser(user);

        List<ResAccountBankDTO> result = accounts.stream()
                .map(acc -> new ResAccountBankDTO(
                        acc.getBankName(),
                        acc.getAccountNumber(),
                        acc.getAccountHolder()
                ))
                .toList();

        return ResponseEntity.ok(result);
    }
    

    @GetMapping("/bankaccount/{number}")
        public ResponseEntity<ResAccountBankDTO> getBankAccountNumber(@PathVariable("number") String number) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = this.userService.handleGetUserByUsername(username);
        
        Optional<BankAccount> account = this.bankAccountService.handleGetBankAccountNumber(number);

        BankAccount bankAccount=account.get();

        ResAccountBankDTO resAccount=new ResAccountBankDTO(bankAccount.getBankName(), bankAccount.getAccountNumber(), bankAccount.getAccountHolder());

        return ResponseEntity.ok(resAccount);
    }

}
