package com.eason.goods.product.domain;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gds_product_details")
@Getter
@EqualsAndHashCode(callSuper = true)
public class ProductDetail extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "place")
    private String place;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @Column(name = "weight")
    private String weight;

    @Column(name = "specification")
    private String specification;

    @Column(name = "picture_url")
    private String pictureUrl;

    private ProductDetail() {
    }

    public ProductDetail(Long id) {
        this.id = id;
    }

    public void describe(String place, String description, String brand, String weight, String specification, String pictureUrl) {
        this.place = place;
        this.description = description;
        this.brand = brand;
        this.weight = weight;
        this.specification = specification;
        this.pictureUrl = pictureUrl;
    }
}
