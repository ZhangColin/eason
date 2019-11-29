package com.eason.base.repositories;

import com.cartisan.repositories.BaseRepository;
import com.eason.base.domains.Country;

import java.util.List;

/**
 * @author colin
 */
public interface CountryRepository extends BaseRepository<Country, Long> {
    List<Country> findByContinentId(Long continentId);
}
