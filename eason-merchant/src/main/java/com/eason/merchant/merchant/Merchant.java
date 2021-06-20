package com.eason.merchant.merchant;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private Merchant() {
    }

    public Merchant(Long id, String name, String shopName, String account, String password, String scope) {
        this.id = id;
        this.name = name;
        this.shopName = shopName;
        this.account = account;
        this.password = password;
        this.scope = scope;
        this.status = 1;
        this.auditStatus = 1;
    }

    public void describe(String name, String shopName, String account, String password, String scope) {
        this.name = name;
        this.shopName = shopName;
        this.account = account;
        this.password = password;
        this.scope = scope;
    }

    public void enable() {
        this.status = 1;
    }

    public void disable() {
        this.status = 0;
    }

    public void approve() {
        this.auditStatus = 2;
    }

    public void reject() {
        this.auditStatus = 3;
    }

}
