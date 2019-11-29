package com.eason.base.dtos;

import com.eason.base.domains.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author colin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String Username;
    private String password;
    private String email;
    private String mobile;

    public static AccountDto convertFrom(Account account) {
        return new AccountDto(account.getId(),
                account.getUsername(), account.getPassword(),
                account.getEmail(), account.getMobile());
    }
}
