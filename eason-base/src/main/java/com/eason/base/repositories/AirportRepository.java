package com.eason.base.repositories;

import com.cartisan.repositories.BaseRepository;
import com.eason.base.domains.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author colin
 */
public interface AirportRepository extends BaseRepository<Airport, Long> {
    List<Airport> findByCityId(Long cityId);

    Page<Airport> findByCityIdIn(Long cityIds[], Pageable pageable);
}
