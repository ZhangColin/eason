package com.eason.system.repositories;

import com.cartisan.repositories.BaseRepository;
import com.eason.system.domains.User;

import java.util.Optional;

/**
 * @author colin
 */
public interface UserRepository extends BaseRepository<User, Long> {

    boolean existsByEmailAndIdNot(String email, Long id);
    boolean existsByEmail(String email);

    boolean existsByPhoneAndIdNot(String telephone, Long id);
    boolean existsByPhone(String telephone);

    Optional<User> findByUsername(String username);
}
