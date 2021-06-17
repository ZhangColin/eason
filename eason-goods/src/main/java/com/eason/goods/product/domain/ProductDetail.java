package com.eason.goods.product.domain;

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

    private ProductDetail() {}

    public ProductDetail(Long id,String place, String description, String brand, String weight, String specification, String pictureUrl) {
        this.id = id;
        this.place = place;
        this.description = description;
        this.brand = brand;
        this.weight = weight;
        this.specification = specification;
        this.pictureUrl = pictureUrl;
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
