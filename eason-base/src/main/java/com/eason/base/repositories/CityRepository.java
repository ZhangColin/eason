package com.eason.base.repositories;

import com.cartisan.repositories.BaseRepository;
import com.eason.base.domains.City;

import java.util.List;

/**
 * @author colin
 */
public interface CityRepository extends BaseRepository<City, Long> {
    List<City> findByCountryId(Long countryId);
}
