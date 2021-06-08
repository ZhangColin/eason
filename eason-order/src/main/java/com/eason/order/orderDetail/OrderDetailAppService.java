package com.eason.order.orderDetail;

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
public class OrderDetailAppService {
    private final OrderDetailRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final OrderDetailConverter converter = OrderDetailConverter.CONVERTER;

    public OrderDetailAppService(OrderDetailRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<OrderDetailDto> searchOrderDetails(@NonNull OrderDetailQuery orderDetailQuery, @NonNull Pageable pageable) {
        final Page<OrderDetail> searchResult = repository.findAll(querySpecification(orderDetailQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public OrderDetailDto getOrderDetail(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderDetailDto addOrderDetail(OrderDetailParam orderDetailParam) {
        final OrderDetail orderDetail = new OrderDetail(idWorker.nextId(),
        orderDetailParam.getOrderId(),
        orderDetailParam.getProductId(),
        orderDetailParam.getMerchantId(),
        orderDetailParam.getTradeNumber());

        return converter.convert(repository.save(orderDetail));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderDetailDto editOrderDetail(Long id, OrderDetailParam orderDetailParam) {
        final OrderDetail orderDetail = requirePresent(repository.findById(id));

        orderDetail.describe(orderDetailParam.getOrderId(),
        orderDetailParam.getProductId(),
        orderDetailParam.getMerchantId(),
        orderDetailParam.getTradeNumber());

        return converter.convert(repository.save(orderDetail));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeOrderDetail(long id) {
        repository.deleteById(id);
    }
}
