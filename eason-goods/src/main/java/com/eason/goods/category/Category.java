package com.eason.goods.category;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "gds_product_categories")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Category extends AbstractEntity implements AggregateRoot {
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

    private Category() {
    }

    public Category(Long parentId,
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
