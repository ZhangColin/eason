package com.eason.order.order.domain;

import com.cartisan.domains.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

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

    private OrderItem() {
    }

    public OrderItem(Long productId, Long merchantId) {
        this.productId = productId;
        this.merchantId = merchantId;
    }
}
