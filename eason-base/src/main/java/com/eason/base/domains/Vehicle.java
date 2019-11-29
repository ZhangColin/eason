package com.eason.base.domains;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author colin
 */
@Entity
@Table(name = "bas_vehicles")
@Where(clause = "active=1 and deleted=0")
@Data
@EqualsAndHashCode(callSuper = false)
public class Vehicle extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "passengers")
    private Integer passengers;
    @Column(name = "passengers_description")
    private String passengersDescription;
    @Column(name = "big_luggage")
    private Integer bigLuggage;
    @Column(name = "small_luggage")
    private Integer smallLuggage;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Column(name = "country_id")
    private Long countryId;
    @Column(name = "country_name")
    private String countryName;
}
