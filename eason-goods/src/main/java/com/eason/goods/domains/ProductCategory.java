package com.eason.goods.domains;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author colin
 */
@Entity
@Table(name = "goods_product_categories")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductCategory extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "level")
    private Integer level;
    @Column(name = "product_count")
    private Integer productCount;
    @Column(name = "product_unit")
    private String productUnit;
    @Column(name = "show_navigation")
    private Boolean showNavigation;
    @Column(name = "is_show")
    private Boolean isShow;
    @Column(name = "icon")
    private String icon;
    @Column(name = "keywords")
    private String keywords;
    @Column(name = "description")
    private String description;
    @Column(name = "sort")
    private Integer sort;

    public ProductCategory() {
        this.productCount = 0;
    }
}
