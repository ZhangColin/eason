package com.eason.order.order.domain;

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
public class OrderItem extends AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "merchant_id")
    private Long merchantId;

    private OrderItem() {}

    public OrderItem(Long productId, Long merchantId) {
        this.productId = productId;
        this.merchantId = merchantId;
    }
}
