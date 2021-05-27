package com.eason.membership.config;

import com.cartisan.repositories.CartisanRepositoryFactoryBean;
import com.cartisan.utils.SnowflakeIdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.eason.membership"},
        repositoryFactoryBeanClass = CartisanRepositoryFactoryBean.class)
@MapperScan("com.eason.membership.**.mapper")
public class ApplicationConfig {
    @Bean
    public SnowflakeIdWorker idWorker() {
        return new SnowflakeIdWorker(1, 1);
    }
}
