package com.eason.merchant.merchant;

import com.cartisan.repositories.BaseRepository;

public interface MerchantRepository extends BaseRepository<Merchant, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
