package com.atul.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.atul.persistent.dao")
@EntityScan(basePackages = "com.atul.persistent.model")
@EnableTransactionManagement
public class JPAConfig {

}
