package com.phoenixcontact.appstore.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.phoenixcontact.appstore.domain"})
@EnableJpaRepositories(basePackages = {"com.phoenixcontact.appstore.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
