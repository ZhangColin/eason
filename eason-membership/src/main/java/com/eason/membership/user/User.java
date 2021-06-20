package com.eason.membership.user;

import com.cartisan.domains.AbstractEntity;
import com.cartisan.domains.AggregateRoot;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ms_users")
@Getter
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
    private String passwordEncrypt;

    @Column(name = "address")
    private String address;

    @Column(name = "telphone")
    private String telphone;

    @Column(name = "qq")
    private String qq;

    @Column(name = "email")
    private String email;

    @Column(name = "weixin")
    private String weixin;

    @Column(name = "sex")
    private String sex;

    private User() {
    }

    public User(Long id,
                String name,
                Integer age,
                String account,
                String passwordEncrypt,
                String address,
                String telphone,
                String qq,
                String email,
                String weixin,
                String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.account = account;
        this.passwordEncrypt = passwordEncrypt;
        this.address = address;
        this.telphone = telphone;
        this.qq = qq;
        this.email = email;
        this.weixin = weixin;
        this.sex = sex;
    }

    public void describe(String name,
                         Integer age,
                         String account,
                         String passwordEncrypt,
                         String address,
                         String telphone,
                         String qq,
                         String email,
                         String weixin,
                         String sex) {
        this.name = name;
        this.age = age;
        this.account = account;
        this.passwordEncrypt = passwordEncrypt;
        this.address = address;
        this.telphone = telphone;
        this.qq = qq;
        this.email = email;
        this.weixin = weixin;
        this.sex = sex;
    }
}
