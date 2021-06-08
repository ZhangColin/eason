package com.eason.order.order;

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
import java.lang.Integer;

import static java.util.stream.Collectors.toList;

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

    private Order() {}

    public Order(Long id,
        Long userId,
        Integer payAmount,
        String consigneeAddress,
        String consigneePhone,
        String consigneeName,
        String tradeNumber,
        Integer orderStatus,
        Integer payStatus) {
        this.id = id;
        this.userId = userId;
        this.payAmount = payAmount;
        this.consigneeAddress = consigneeAddress;
        this.consigneePhone = consigneePhone;
        this.consigneeName = consigneeName;
        this.tradeNumber = tradeNumber;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
    }

    public void describe(Long userId,
        Integer payAmount,
        String consigneeAddress,
        String consigneePhone,
        String consigneeName,
        String tradeNumber,
        Integer orderStatus,
        Integer payStatus) {
        this.userId = userId;
        this.payAmount = payAmount;
        this.consigneeAddress = consigneeAddress;
        this.consigneePhone = consigneePhone;
        this.consigneeName = consigneeName;
        this.tradeNumber = tradeNumber;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
    }
}
