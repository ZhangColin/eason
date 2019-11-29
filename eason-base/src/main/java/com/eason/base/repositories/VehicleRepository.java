package com.eason.base.repositories;

import com.cartisan.repositories.BaseRepository;
import com.eason.base.domains.Vehicle;

import java.util.List;

/**
 * @author colin
 */
public interface VehicleRepository extends BaseRepository<Vehicle, Long> {
    List<Vehicle> findByCountryId(Long countryId);
}
