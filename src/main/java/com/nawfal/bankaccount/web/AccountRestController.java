package com.nawfal.bankaccount.web;

import com.nawfal.bankaccount.dto.BankAccountResponseDTO;
import com.nawfal.bankaccount.entities.BankAccount;
import com.nawfal.bankaccount.mappers.AccountMapper;
import com.nawfal.bankaccount.repositories.BankAccountRepository;
import com.nawfal.bankaccount.services.IAccountService;
import com.nawfal.bankaccount.dto.BankAccountRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountRestController {

    private IAccountService accountService;
    private BankAccountRepository bankAccountRepository;
    private AccountMapper mapper;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO createAccount(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id, @RequestBody BankAccount account) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow();
        if (account.getBalance()!=null) bankAccount.setBalance(account.getBalance());
        if (account.getCreateAt()!=null) bankAccount.setCreateAt(account.getCreateAt());
        if (account.getCurrency()!=null) bankAccount.setCurrency(account.getCurrency());
        if (account.getAccountType()!=null) bankAccount.setAccountType(account.getAccountType());
        return bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAcccountById(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
