package com.eason.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author colin
 */
@SpringBootApplication(scanBasePackages = {"com.cartisan", "com.eason.goods"})
@EnableEurekaClient
public class GoodsApplication {
    public static void main(String[] args) {SpringApplication.run(GoodsApplication.class, args);
    }
}
