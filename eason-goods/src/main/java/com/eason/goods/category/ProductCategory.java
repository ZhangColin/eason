package com.eason.goods.category;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

@Entity
@Table(name = "gds_product_categories")
@Getter
@EqualsAndHashCode(callSuper = true)
public class ProductCategory extends AbstractEntity implements AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "sort")
    private Integer sort;

    private ProductCategory() {}

    public ProductCategory(Long parentId,
        String name,
        Integer level,
        Integer sort) {
        this.parentId = parentId;
        this.name = name;
        this.level = level;
        this.sort = sort;
    }

    public void describe(Long parentId,
        String name,
        Integer level,
        Integer sort) {
        this.parentId = parentId;
        this.name = name;
        this.level = level;
        this.sort = sort;
    }
}
