package com.eason.membership.account;

import com.cartisan.repositories.BaseRepository;
import com.eason.membership.account.domain.Account;

import java.util.Optional;

/**
 * @author colin
 */
public interface AccountRepository extends BaseRepository<Account, Long> {
    boolean existsByUsername(String username);
    boolean existsByUsernameAndIdNot(String username, Long id);

    boolean existsByPhone(String phone);
    boolean existsByPhoneAndIdNot(String phone, Long id);

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);

    Optional<Account> findByUsername(String username);
}
