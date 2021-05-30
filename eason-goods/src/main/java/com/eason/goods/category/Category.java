package com.eason.goods.category;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

/**
 * @author colin
 */
@Entity
@Table(name = "gds_product_categories")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Category extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "sort")
    private Integer sort;

    private Category() {
    }

    public Category(Long parentId, String name, Integer level, Integer sort) {
        this.parentId = parentId;
        this.name = name;
        this.level = level;
        this.sort = sort;
    }

    public void change(Long parentId, String name, Integer level, Integer sort) {
        this.parentId = parentId;
        this.name = name;
        this.level = level;
        this.sort = sort;
    }
}
