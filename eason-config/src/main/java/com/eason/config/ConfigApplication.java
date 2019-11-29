package com.eason.config;

import com.eason.config.filters.BusRefreshFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

/**
 * @author colin
 */
@SpringCloudApplication
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean busRefreshFilter() {
        BusRefreshFilter filter = new BusRefreshFilter();

        return new FilterRegistrationBean(filter);
    }
}
