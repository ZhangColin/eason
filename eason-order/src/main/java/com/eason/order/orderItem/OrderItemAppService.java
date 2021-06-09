package com.eason.order.orderItem;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cartisan.utils.SnowflakeIdWorker;

import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;
import static java.util.stream.Collectors.toList;

@Service
public class OrderItemAppService {
    private final OrderItemRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final OrderItemConverter converter = OrderItemConverter.CONVERTER;

    public OrderItemAppService(OrderItemRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<OrderItemDto> searchOrderItems(@NonNull OrderItemQuery orderItemQuery, @NonNull Pageable pageable) {
        final Page<OrderItem> searchResult = repository.findAll(querySpecification(orderItemQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public OrderItemDto getOrderItem(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderItemDto addOrderItem(OrderItemParam orderItemParam) {
        final OrderItem orderItem = new OrderItem(idWorker.nextId(),
        orderItemParam.getOrderId(),
        orderItemParam.getProductId(),
        orderItemParam.getMerchantId(),
        orderItemParam.getTradeNumber());

        return converter.convert(repository.save(orderItem));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderItemDto editOrderItem(Long id, OrderItemParam orderItemParam) {
        final OrderItem orderItem = requirePresent(repository.findById(id));

        orderItem.describe(orderItemParam.getOrderId(),
        orderItemParam.getProductId(),
        orderItemParam.getMerchantId(),
        orderItemParam.getTradeNumber());

        return converter.convert(repository.save(orderItem));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeOrderItem(long id) {
        repository.deleteById(id);
    }
}
