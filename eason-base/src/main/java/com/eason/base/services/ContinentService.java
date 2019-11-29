package com.eason.base.services;

import com.eason.base.dtos.ContinentDto;
import com.eason.base.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author colin
 */
@Service
public class ContinentService {
    private final ContinentRepository continentRepository;

    @Autowired
    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Cacheable(value="cache:base:services:ContinentService:findContinents")
    public List<ContinentDto> findContinents() {
        return continentRepository.findAll().stream().map(ContinentDto::convertFrom).collect(Collectors.toList());
    }
}
