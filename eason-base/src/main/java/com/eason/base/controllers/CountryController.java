package com.eason.base.controllers;

import com.cartisan.responses.GenericResponse;
import com.eason.base.dtos.CountryDto;
import com.eason.base.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cartisan.responses.GenericResponse.success;

/**
 * @author colin
 */
@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public GenericResponse<List<CountryDto>> findCountries(@RequestParam Long continentId) {
        return success(countryService.findCountries(continentId));
    }

    @GetMapping("/search")
    public GenericResponse<List<CountryDto>> searchCountries(
            @RequestParam(required = false) Long continentId,
            @RequestParam(required = false) String name) {
        return success(countryService.searchCountries(continentId, name));
    }
}
