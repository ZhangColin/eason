package com.eason.merchant.merchant;

import com.cartisan.domains.AggregateRoot;
import com.cartisan.domains.SoftDeleteEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author colin
 */
@Entity
@Table(name = "mch_merchants")
@Getter
@EqualsAndHashCode(callSuper = true)
@Where(clause = "active=1 and deleted=0")
public class Merchant extends SoftDeleteEntity implements AggregateRoot {
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
    private int status;

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
}
