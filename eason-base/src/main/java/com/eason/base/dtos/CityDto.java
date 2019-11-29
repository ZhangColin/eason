package com.eason.base.dtos;

import com.eason.base.domains.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author colin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String code;
    private String name;
    private String englishName;
    private String fullPinYin;
    private String simplePinYin;
    private Long countryId;
    private String countryName;
    private String latitude;
    private String longitude;

    public static CityDto convertFrom(City city) {
        return new CityDto(city.getId(), city.getCode(),
                city.getName(), city.getEnglishName(),
                city.getFullPinYin(), city.getSimplePinYin(),
                city.getCountryId(), city.getCountryName(),
                city.getLatitude(), city.getLongitude());
    }
}
