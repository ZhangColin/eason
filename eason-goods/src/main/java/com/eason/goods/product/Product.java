package com.eason.goods.product;

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
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "gds_products")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "title")
    private String title;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "price")
    private Integer price;

    @Column(name = "stock_number")
    private Integer stockNumber;

    @Column(name = "sell_number")
    private Integer sellNumber;

    @Column(name = "audit_status")
    private Integer auditStatus;

    @Column(name = "audited")
    private Date audited;

    @Column(name = "status")
    private Integer status;

    private Product() {}

    public Product(Long id,
        Long categoryId,
        Long merchantId,
        String title,
        String pictureUrl,
        Integer price,
        Integer stockNumber,
        Integer sellNumber,
        Integer auditStatus,
        Date audited,
        Integer status) {
        this.id = id;
        this.categoryId = categoryId;
        this.merchantId = merchantId;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.stockNumber = stockNumber;
        this.sellNumber = sellNumber;
        this.auditStatus = auditStatus;
        this.audited = audited;
        this.status = status;
    }

    public void describe(Long categoryId,
        Long merchantId,
        String title,
        String pictureUrl,
        Integer price,
        Integer stockNumber,
        Integer sellNumber,
        Integer auditStatus,
        Date audited,
        Integer status) {
        this.categoryId = categoryId;
        this.merchantId = merchantId;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.stockNumber = stockNumber;
        this.sellNumber = sellNumber;
        this.auditStatus = auditStatus;
        this.audited = audited;
        this.status = status;
    }
}
