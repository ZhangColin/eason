package com.eason.order.order.response;

import com.cartisan.dtos.Converter;
import com.eason.order.order.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailConverter extends Converter<Order, OrderDetailDto> {
    OrderDetailConverter CONVERTER = Mappers.getMapper(OrderDetailConverter.class);
}
