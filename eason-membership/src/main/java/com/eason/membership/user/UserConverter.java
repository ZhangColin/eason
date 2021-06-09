package com.eason.membership.user;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter extends Converter<User, UserDto> {
    UserConverter CONVERTER = Mappers.getMapper(UserConverter.class);
}
