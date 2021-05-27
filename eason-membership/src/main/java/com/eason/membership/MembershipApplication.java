package com.eason.membership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cartisan", "com.eason.membership"})
public class MembershipApplication {
    public static void main(String[] args) {
        SpringApplication.run(MembershipApplication.class, args);
    }
}
