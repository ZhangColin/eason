package com.eason.order.orderItem;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import java.lang.Long;
import java.lang.String;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "ord_order_items")
@Getter
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "trade_number")
    private String tradeNumber;

    private OrderItem() {}

    public OrderItem(Long id,
        Long orderId,
        Long productId,
        Long merchantId,
        String tradeNumber) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.merchantId = merchantId;
        this.tradeNumber = tradeNumber;
    }

    public void describe(Long orderId,
        Long productId,
        Long merchantId,
        String tradeNumber) {
        this.orderId = orderId;
        this.productId = productId;
        this.merchantId = merchantId;
        this.tradeNumber = tradeNumber;
    }
}
