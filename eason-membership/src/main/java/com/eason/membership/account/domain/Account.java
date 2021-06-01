//package com.eason.membership.account.domain;
//
//import com.cartisan.domains.AggregateRoot;
//import com.cartisan.domains.SoftDeleteEntity;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
//import org.hibernate.annotations.Where;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static java.util.stream.Collectors.toList;
//
///**
// * @author colin
// */
//@Entity
//@Table(name = "ms_accounts")
//@Getter
//@EqualsAndHashCode(callSuper = true)
//@Where(clause = "active=1 and deleted=0")
//public class Account extends SoftDeleteEntity implements AggregateRoot {
//    @Id
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "username")
//    private String username;
//    @Column(name = "phone")
//    private String phone;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "avatar")
//    @Setter
//    private String avatar;
//
//    @Column(name = "status")
//    private Integer status;
//
//    private Account() {
//
//    }
//
//    public Account(Long id, String username, String phone, String email, String password) {
//        this.id = id;
//
//        this.username = username;
//        this.phone = Optional.ofNullable(phone).orElse("");
//        this.email = Optional.ofNullable(email).orElse("");
//        this.password = password;
//
//        this.avatar = "";
//        this.status = 1;
//    }
//
//    public void disable() {
//        this.status = 2;
//    }
//
//    public void enable() {
//        this.status = 1;
//    }
//
//    public void changePassword(String password) {
//        this.password = password;
//    }
//}
