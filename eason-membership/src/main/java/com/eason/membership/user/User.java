package com.eason.membership.user;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author colin
 */
@Entity
@Table(name = "ms_users")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity implements AggregateRoot {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "account")
    private String account;
    @Column(name = "password_encrypt")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "telphone")
    private String telphone;
    @Column(name = "qq")
    private String qq;
    @Column(name = "weixin")
    private String weixin;
    @Column(name = "email")
    private String email;
    @Column(name = "sex")
    private String sex;
}
