package com.example.nckh2026.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.nckh2026.domain.BankAccount;
import com.example.nckh2026.domain.User;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>, JpaSpecificationExecutor<BankAccount>{
    List<BankAccount> findByUser(User user);

    Optional<BankAccount> findByAccountNumber(String accountNumber);
}
