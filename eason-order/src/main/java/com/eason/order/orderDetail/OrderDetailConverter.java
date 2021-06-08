package com.eason.order.orderDetail;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailConverter extends Converter<OrderDetail, OrderDetailDto> {
    OrderDetailConverter CONVERTER = Mappers.getMapper(OrderDetailConverter.class);
}
