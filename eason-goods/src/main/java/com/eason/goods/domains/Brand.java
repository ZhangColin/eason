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
@Table(name = "goods_brands")
@Data
@EqualsAndHashCode(callSuper = true)
public class Brand extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "first_letter")
    private String firstLetter;
    @Column(name = "is_manufacturer")
    private Boolean isManufacturer;
    @Column(name = "is_show")
    private Boolean isShow;
    @Column(name = "logo")
    private String logo;
    @Column(name = "big_pic")
    private String bigPic;
    @Column(name = "sort")
    private Integer sort;
}
