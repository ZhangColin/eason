package com.eason.base.dtos;

import com.eason.base.domains.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author colin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto{
    private Long id;
    private String code;
    private String name;
    private String englishName;
    private String fullPinYin;
    private String simplePinYin;
    private Long cityId;
    private String cityName;
    private String latitude;
    private String longitude;

    public static AirportDto convertFrom(Airport airport) {
        return new AirportDto(airport.getId(), airport.getCode(),
                airport.getName(), airport.getEnglishName(),
                airport.getFullPinYin(), airport.getSimplePinYin(),
                airport.getCityId(), airport.getCityName(),
                airport.getLatitude(), airport.getLongitude());
    }
}
