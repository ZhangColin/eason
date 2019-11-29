package com.eason.base.controllers;

import com.cartisan.dtos.PageResult;
import com.cartisan.responses.GenericResponse;
import com.eason.base.dtos.CityDto;
import com.eason.base.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cartisan.responses.GenericResponse.success;

/**
 * @author colin
 */
@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public GenericResponse<List<CityDto>> findCities(@RequestParam Long countryId) {
        return success(cityService.findCities(countryId));
    }

    @GetMapping("/search/{currentPage}/{pageSize}")
    public GenericResponse<PageResult<CityDto>> searchAirports(
            @RequestParam(required = false) Long[] countryIds,
            @RequestParam(required = false) String name,
            @PathVariable Integer currentPage,
            @PathVariable Integer pageSize) {
        return success(cityService.searchCities(countryIds, name, currentPage, pageSize));
    }
}

