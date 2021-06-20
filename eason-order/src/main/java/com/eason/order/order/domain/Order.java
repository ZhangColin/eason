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

@Entity
@Table(name = "ord_orders")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pay_amount")
    private Integer payAmount;

    @Column(name = "consignee_address")
    private String consigneeAddress;

    @Column(name = "consignee_phone")
    private String consigneePhone;

    @Column(name = "consignee_name")
    private String consigneeName;

    @Column(name = "trade_number")
    private String tradeNumber;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "pay_status")
    private Integer payStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    private Order() {
    }

    public Order(Long id, Long userId, Integer payAmount,
                 String consigneeAddress, String consigneePhone, String consigneeName) {
        this.id = id;
        this.userId = userId;
        this.payAmount = payAmount;
        this.consigneeAddress = consigneeAddress;
        this.consigneePhone = consigneePhone;
        this.consigneeName = consigneeName;

        this.tradeNumber = "T" + id;
        this.orderStatus = 1;
        this.payStatus = 1;
    }

    public void addItem(Long productId, Long merchantId) {
        this.items.add(new OrderItem(productId, merchantId));
    }

    public void changeConsignee(String consigneeAddress, String consigneePhone, String consigneeName) {
        this.consigneeAddress = consigneeAddress;
        this.consigneePhone = consigneePhone;
        this.consigneeName = consigneeName;
    }

    public void cancel() {
        this.orderStatus = 2;
        if (this.payStatus == 2) {
            this.payStatus = 3;
        }
    }

    public void pay() {
        this.payStatus = 2;
    }
}
