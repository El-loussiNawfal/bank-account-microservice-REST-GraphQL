package com.nawfal.bankaccount.repositories;

import com.nawfal.bankaccount.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
