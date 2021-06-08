package com.eason.order.config;

import com.cartisan.repositories.CartisanRepositoryFactoryBean;
import com.cartisan.utils.SnowflakeIdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author colin
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.eason.order"},
        repositoryFactoryBeanClass = CartisanRepositoryFactoryBean.class)
@MapperScan("com.eason.order.**.mapper")
public class ApplicationConfig {
    @Bean
    public SnowflakeIdWorker idWorker() {
        return new SnowflakeIdWorker(1, 1);
    }
}
