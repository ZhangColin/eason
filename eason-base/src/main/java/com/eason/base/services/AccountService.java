package com.eason.base.services;

import com.cartisan.utils.SnowflakeIdWorker;
import com.eason.base.domains.Account;
import com.eason.base.dtos.AccountDto;
import com.eason.base.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author colin
 */
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final SnowflakeIdWorker idWorker;

    @Autowired
    public AccountService(AccountRepository accountRepository, SnowflakeIdWorker idWorker) {
        this.accountRepository = accountRepository;
        this.idWorker = idWorker;
    }

//    @Autowired
//    private BCryptPasswordEncoder encoder;

    @Cacheable(value = "cache:base:services:AccountService:findAccount", key = "#account")
    public AccountDto findAccount(Long accountId) {
        return AccountDto.convertFrom(accountRepository.findById(accountId).get());
    }

    public void createAccount(AccountDto accountDto) {
        final long accountId = idWorker.nextId();

        final Account account = new Account(accountId, accountDto.getUsername(),
//                encoder.encode(accountDto.getPassword()),
                accountDto.getPassword(),
                accountDto.getEmail(), accountDto.getMobile());

        accountRepository.save(account);
    }

//    public void changePassword(Long accountId, String orig)
}
