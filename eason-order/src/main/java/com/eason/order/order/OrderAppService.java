package com.eason.order.order;

import com.cartisan.dtos.PageResult;
import com.cartisan.utils.SnowflakeIdWorker;
import com.eason.order.order.domain.Order;
import com.eason.order.order.request.ChangeConsigneeCommand;
import com.eason.order.order.request.OrderQuery;
import com.eason.order.order.request.PlaceCommand;
import com.eason.order.order.response.OrderConverter;
import com.eason.order.order.response.OrderDetailConverter;
import com.eason.order.order.response.OrderDetailDto;
import com.eason.order.order.response.OrderDto;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;

@Service
public class OrderAppService {
    private final OrderRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final OrderConverter converter = OrderConverter.CONVERTER;
    private final OrderDetailConverter detailConverter = OrderDetailConverter.CONVERTER;

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

    public OrderDetailDto getOrder(Long id) {
        return detailConverter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderDto place(PlaceCommand placeCommand) {
        final Order order = new Order(idWorker.nextId(),
                placeCommand.getUserId(),
                placeCommand.getPayAmount(),
                placeCommand.getConsigneeAddress(),
                placeCommand.getConsigneePhone(),
                placeCommand.getConsigneeName());

        placeCommand.getItems().forEach(orderItemParam ->
                order.addItem(orderItemParam.getProductId(), orderItemParam.getMerchantId()));

        return converter.convert(repository.save(order));
    }

    @Transactional(rollbackOn = Exception.class)
    public OrderDto changeConsignee(ChangeConsigneeCommand command) {
        final Order order = requirePresent(repository.findById(command.getOrderId()));

        order.changeConsignee(command.getConsigneeAddress(), command.getConsigneePhone(), command.getConsigneeName());

        return converter.convert(repository.save(order));
    }

    @Transactional(rollbackOn = Exception.class)
    public void cancel(long id) {
        final Order order = requirePresent(repository.findById(id));
        order.cancel();

        repository.save(order);
    }

    @Transactional(rollbackOn = Exception.class)
    public void pay(long id) {
        final Order order = requirePresent(repository.findById(id));
        order.pay();

        repository.save(order);
    }


}
