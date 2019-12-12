package com.eason.base.controllers;

import com.cartisan.dtos.PageResult;
import com.eason.base.dtos.AirportDto;
import com.eason.base.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cartisan.responses.ResponseUtil.success;

/**
 * @author colin
 */
@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<AirportDto> findAirports(@RequestParam Long cityId) {
        return airportService.findAirports(cityId);
    }

    @GetMapping("/search/{currentPage}/{pageSize}")
    public ResponseEntity<PageResult<AirportDto>> searchAirports(
            @RequestParam(required = false) Long[] cityIds,
            @PathVariable Integer currentPage,
            @PathVariable Integer pageSize) {
        return success(airportService.searchAirports(cityIds, currentPage, pageSize));
    }

}

