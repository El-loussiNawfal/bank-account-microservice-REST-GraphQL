package com.nawfal.bankaccount.services;

import com.nawfal.bankaccount.dto.BankAccountRequestDTO;
import com.nawfal.bankaccount.dto.BankAccountResponseDTO;

public interface IAccountService {

     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
