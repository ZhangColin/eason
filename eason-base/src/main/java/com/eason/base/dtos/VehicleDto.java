package com.eason.base.dtos;

import com.eason.base.domains.Vehicle;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author colin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto{
    @ApiModelProperty(value = "车型Id", required = true)
    private Long id;
    @ApiModelProperty(value = "车型编号", required = true)
    private String code;
    @ApiModelProperty(value = "车型名称", required = true)
    private String name;
    @ApiModelProperty(value = "车型描述", required = true)
    private String description;
    @ApiModelProperty(value = "乘座人数", required = true)
    private Integer passengers;
    @ApiModelProperty(value = "空间描述", required = true)
    private String passengersDescription;
    @ApiModelProperty(value = "大行李数", required = true)
    private Integer bigLuggage;
    @ApiModelProperty(value = "小行李数", required = true)
    private Integer smallLuggage;
    @ApiModelProperty(value = "图片")
    private String pictureUrl;
    @ApiModelProperty(value = "国家Id", required = true)
    private Long countryId;
    @ApiModelProperty(value = "国家", required = true)
    private String countryName;

    public static VehicleDto convertFrom(Vehicle vehicle) {
        return new VehicleDto(vehicle.getId(), vehicle.getCode(),
                vehicle.getName(), vehicle.getDescription(),
                vehicle.getPassengers(), vehicle.getPassengersDescription(),
                vehicle.getBigLuggage(), vehicle.getSmallLuggage(),
                vehicle.getPictureUrl(),
                vehicle.getCountryId(), vehicle.getCountryName());
    }
}
