package com.nawfal.bankaccount.services;

import com.nawfal.bankaccount.entities.BankAccount;
import com.nawfal.bankaccount.mappers.AccountMapper;
import com.nawfal.bankaccount.dto.BankAccountRequestDTO;
import com.nawfal.bankaccount.dto.BankAccountResponseDTO;
import com.nawfal.bankaccount.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private BankAccountRepository bankAccountRepository;
    private AccountMapper mapper;


    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount account = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .accountType(bankAccountRequestDTO.getAccountType())
                .build();
        BankAccount bankAccount = bankAccountRepository.save(account);
        BankAccountResponseDTO responseDTO = mapper.fromBankAccount(bankAccount);
        return responseDTO;
    }


    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount account = BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .accountType(bankAccountRequestDTO.getAccountType())
                .build();
        BankAccount bankAccount = bankAccountRepository.save(account);
        BankAccountResponseDTO responseDTO = mapper.fromBankAccount(bankAccount);
        return responseDTO;
    }
}
