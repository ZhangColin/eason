package com.eason.goods.product.domain;

import com.cartisan.constants.CodeMessage;
import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import com.cartisan.exceptions.CartisanException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime audited;

    @Column(name = "status")
    private Integer status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id")
    private ProductDetail productDetail;

    private Product() {
    }

    public Product(Long id, Long categoryId, Long merchantId, String title, String pictureUrl, Integer price) {
        this.id = id;
        this.categoryId = categoryId;
        this.merchantId = merchantId;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.stockNumber = 0;
        this.sellNumber = 0;
        this.auditStatus = 0;
        this.status = 0;

        this.productDetail = new ProductDetail(id);
    }

    public void describe(Long categoryId, Long merchantId, String title, String pictureUrl, Integer price) {
        this.categoryId = categoryId;
        this.merchantId = merchantId;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
    }

    public void setDetail(String place, String description, String brand, String weight, String specification, String pictureUrl) {
        this.productDetail.describe(place, description, brand, weight, specification, pictureUrl);
    }

    public void approve() {
        this.audited = LocalDateTime.now();
        this.auditStatus = 2;
    }

    public void reject() {
        this.auditStatus = 3;
    }

    public void putaway() {
        this.status = 1;
    }

    public void soldOut() {
        this.status = 0;
    }

    public void addStock(Integer count) {
        this.stockNumber += count;
    }

    public void sell(Integer count) {
        if (count > this.stockNumber) {
            throw new CartisanException(CodeMessage.FAIL.fillArgs("库存不足"));
        }
        this.stockNumber -= count;
        this.sellNumber += count;
    }
}
