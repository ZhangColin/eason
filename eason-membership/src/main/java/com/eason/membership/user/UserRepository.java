package com.eason.membership.user;

import com.cartisan.repositories.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {
    Optional<User> findByName(String name);
}
