package com.eason.goods.product;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

/**
 * @author colin
 */
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
    }

    public void describe( Long categoryId, Long merchantId, String title, String pictureUrl, Integer price) {
        this.categoryId = categoryId;
        this.merchantId = merchantId;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
    }

    public void stock(Integer number){
        this.stockNumber+=number;
    }

    public void sell(Integer number){
        if (this.stockNumber>=number){
            this.stockNumber-=number;
            this.sellNumber+=number;
        }
    }

    public void allow() {
        this.auditStatus = 1;
    }

    public void deny() {
        this.auditStatus = 0;
    }
}
