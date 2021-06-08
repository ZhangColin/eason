package com.eason.order.order;

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
public class OrderAppService {
    private final OrderRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final OrderConverter converter = OrderConverter.CONVERTER;

    public OrderAppService(OrderRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<OrderDto> searchOrders(@NonNull OrderQuery orderQuery, @NonNull Pageable pageable) {
        final Page<Order> searchResult = repository.findAll(querySpecification(orderQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public OrderDto getOrder(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderDto addOrder(OrderParam orderParam) {
        final Order order = new Order(idWorker.nextId(),
        orderParam.getUserId(),
        orderParam.getPayAmount(),
        orderParam.getConsigneeAddress(),
        orderParam.getConsigneePhone(),
        orderParam.getConsigneeName(),
        orderParam.getTradeNumber(),
        orderParam.getOrderStatus(),
        orderParam.getPayStatus());

        return converter.convert(repository.save(order));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderDto editOrder(Long id, OrderParam orderParam) {
        final Order order = requirePresent(repository.findById(id));

        order.describe(orderParam.getUserId(),
        orderParam.getPayAmount(),
        orderParam.getConsigneeAddress(),
        orderParam.getConsigneePhone(),
        orderParam.getConsigneeName(),
        orderParam.getTradeNumber(),
        orderParam.getOrderStatus(),
        orderParam.getPayStatus());

        return converter.convert(repository.save(order));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeOrder(long id) {
        repository.deleteById(id);
    }
}
