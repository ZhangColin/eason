package com.eason.membership.user;

import com.cartisan.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository extends BaseRepository<User, Long> {

}
