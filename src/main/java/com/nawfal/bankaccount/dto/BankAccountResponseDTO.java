package com.nawfal.bankaccount.dto;

import com.nawfal.bankaccount.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createAt;
    private double balance;
    private String currency;
    private AccountType accountType;
}
