package com.phoenixcontact.prototype.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.phoenixcontact.prototype.domain"})
@EnableJpaRepositories(basePackages = {"com.phoenixcontact.prototype.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
