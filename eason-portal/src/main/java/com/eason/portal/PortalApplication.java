package com.eason.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author colin
 */
@SpringBootApplication(scanBasePackages = {"com.cartisan", "com.eason.portal"})
//@EnableEurekaClient
@EnableFeignClients
public class PortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
