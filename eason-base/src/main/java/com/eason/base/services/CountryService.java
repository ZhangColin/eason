package com.eason.base.services;

import com.eason.base.domains.Country;
import com.eason.base.dtos.CountryDto;
import com.eason.base.repositories.CountryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author colin
 */
@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Cacheable(value="cache:base:services:CountryService:findCountries", key="#continentId")
    public List<CountryDto> findCountries(Long continentId) {
        return countryRepository.findByContinentId(continentId)
                .stream().map(CountryDto::convertFrom).collect(Collectors.toList());
    }

    public List<CountryDto> searchCountries(Long continentId, String name) {
        return countryRepository.findAll((Specification<Country>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (continentId != null) {
                predicateList.add(criteriaBuilder.equal(root.get("continentId"), continentId));
            }

            if (StringUtils.isNotBlank(name)) {
                predicateList.add(criteriaBuilder.like(root.get("name"),
                        "%" + name + "%"));
            }

            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        }).stream().map(CountryDto::convertFrom).collect(Collectors.toList());
    }
}
