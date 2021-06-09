package com.eason.order.orderItem;

import com.cartisan.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderItemRepository extends BaseRepository<OrderItem, Long> {

}
