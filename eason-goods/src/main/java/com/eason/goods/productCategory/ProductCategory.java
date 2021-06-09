package com.eason.goods.productCategory;

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

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private Integer level;

    @Column(name = "sort")
    private Integer sort;

    private ProductCategory() {}

    public ProductCategory(Long parentId,
        String name,
        String description,
        Integer level,
        Integer sort) {
        
        this.parentId = parentId;
        this.name = name;
        this.description = description;
        this.level = level;
        this.sort = sort;
    }

    public void describe(Long parentId,
        String name,
        String description,
        Integer level,
        Integer sort) {
        this.parentId = parentId;
        this.name = name;
        this.description = description;
        this.level = level;
        this.sort = sort;
    }
}
