package com.eason.base.controllers;

import com.eason.base.dtos.VehicleDto;
import com.eason.base.services.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cartisan.responses.ResponseUtil.success;

/**
 * @author colin
 */
@Api(tags = "车型")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ApiOperation(value = "获取指定国家下的车型")
    @GetMapping
    public ResponseEntity<List<VehicleDto>> findVehicles(
            @ApiParam(value = "国家", required = true) @RequestParam Long countryId) {
        return success(vehicleService.findVehicles(countryId));
    }

    @ApiOperation(value = "添加车型", notes = "添加车型")
    @PostMapping
    public ResponseEntity addVehicle(
            @ApiParam(value = "车型信息", required = true) @RequestBody VehicleDto vehicleDto) {
        vehicleService.addVehicle(vehicleDto);

        return success();
    }

    @ApiOperation(value = "更新车型", notes = "更新车型")
    @PutMapping("/{id}")
    public ResponseEntity editVehicle(
            @ApiParam(value = "车型Id", required = true) @PathVariable Long id,
            @ApiParam(value = "车型信息", required = true) @RequestBody VehicleDto vehicleDto) {
        vehicleService.editVehicle(id, vehicleDto);

        return success();
    }

    @ApiOperation(value = "删除车型", notes = "删除车型")
    @DeleteMapping("/{id}")
    public ResponseEntity removeVehicle(
            @ApiParam(value = "车型Id", required = true) @PathVariable long id) {
        vehicleService.removeVehicle(id);

        return success();
    }

}

