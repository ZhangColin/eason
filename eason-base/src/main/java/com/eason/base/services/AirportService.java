package com.eason.base.services;

import com.cartisan.dtos.PageResult;
import com.eason.base.domains.Airport;
import com.eason.base.dtos.AirportDto;
import com.eason.base.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author colin
 */
@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Cacheable(value="cache:base:services:AirportService:findAirports", key="#cityId")
    public List<AirportDto> findAirports(Long cityId) {
        List<Airport> airports = airportRepository.findByCityId(cityId);

        return airports.stream().map(AirportDto::convertFrom).collect(Collectors.toList());

    }

    public PageResult<AirportDto> searchAirports(Long[] cityIds, Integer currentPage, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize);

        final Page<Airport> searchResult =
                cityIds!=null && cityIds.length>0?
                airportRepository.findByCityIdIn(cityIds, pageRequest):
                airportRepository.findAll(pageRequest);

        return new PageResult<>(searchResult.getTotalElements(),searchResult.getTotalPages(),
                searchResult.map(AirportDto::convertFrom).getContent());
    }

}


