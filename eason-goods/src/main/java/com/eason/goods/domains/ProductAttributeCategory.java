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
@Table(name = "goods_product_attribute_categories")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductAttributeCategory extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "specification_count")
    private Integer specificationCount;
    @Column(name = "param_count")
    private Integer paramCount;

    private ProductAttributeCategory() {
    }

    public ProductAttributeCategory(String name) {
        this.name = name;
        this.specificationCount = 0;
        this.paramCount = 0;
    }

    public void specificationCountIncrement() {
        this.specificationCount++;
    }

    public void specificationCountDecrement() {
        this.specificationCount--;
    }

    public void paramCountIncrement() {
        this.paramCount++;
    }

    public void paramCountDecrement() {
        this.paramCount--;
    }
}
