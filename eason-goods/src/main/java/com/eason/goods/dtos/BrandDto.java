package com.eason.goods.dtos;

import com.eason.goods.domains.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author colin
 */
@Data
@AllArgsConstructor
public class BrandDto {
    private Long id;
    private String name;
    private String firstLetter;
    private Boolean isManufacturer;
    private Boolean isShow;
    private String logo;
    private String bigPic;
    private Integer sort;

    public static BrandDto convertFrom(Brand brand) {
        return new BrandDto(brand.getId(), brand.getName(), brand.getFirstLetter(),
                brand.getIsManufacturer(), brand.getIsShow(), brand.getLogo(),
                brand.getBigPic(), brand.getSort());
    }
}
