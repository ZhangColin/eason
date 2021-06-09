package com.eason.merchant.merchant;

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
@Table(name = "mch_merchants")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Merchant extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "scope")
    private String scope;

    @Column(name = "status")
    private Integer status;

    @Column(name = "audit_status")
    private Integer auditStatus;

    private Merchant() {}

    public Merchant(Long id,
        String name,
        String shopName,
        String account,
        String password,
        String scope,
        Integer status,
        Integer auditStatus) {
        this.id = id;
        this.name = name;
        this.shopName = shopName;
        this.account = account;
        this.password = password;
        this.scope = scope;
        this.status = status;
        this.auditStatus = auditStatus;
    }

    public void describe(String name,
        String shopName,
        String account,
        String password,
        String scope,
        Integer status,
        Integer auditStatus) {
        this.name = name;
        this.shopName = shopName;
        this.account = account;
        this.password = password;
        this.scope = scope;
        this.status = status;
        this.auditStatus = auditStatus;
    }
}
