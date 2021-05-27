package com.eason.merchant.merchant.response;

import com.cartisan.dtos.Converter;
import com.eason.merchant.merchant.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author colin
 */
@Mapper
public interface MerchantConverter extends Converter<Merchant, MerchantDto> {
    MerchantConverter CONVERTER = Mappers.getMapper(MerchantConverter.class);
}
