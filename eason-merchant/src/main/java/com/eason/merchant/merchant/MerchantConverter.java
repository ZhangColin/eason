package com.eason.merchant.merchant;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MerchantConverter extends Converter<Merchant, MerchantDto> {
    MerchantConverter CONVERTER = Mappers.getMapper(MerchantConverter.class);
}
