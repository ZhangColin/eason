package com.eason.base.controllers;

import com.cartisan.responses.GenericResponse;
import com.eason.base.dtos.ContinentDto;
import com.eason.base.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cartisan.responses.GenericResponse.success;

/**
 * @author colin
 */
@RestController
@RequestMapping("/continent")
public class ContinentController {
    private final ContinentService continentService;

    @Autowired
    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping
    public GenericResponse<List<ContinentDto>> findContinents() {
        return success(continentService.findContinents());
    }
}
