package com.eason.system.config;

import com.cartisan.repositories.CartisanRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author colin
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.eason.system"},
        repositoryFactoryBeanClass = CartisanRepositoryFactoryBean.class)
public class SystemConfig {
}
