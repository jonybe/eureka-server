package com.onfleek.application.configuration;

import com.onfleek.application.dataprovider.AccountDatabaseDataProvider;
import com.onfleek.application.dataprovider.AccountMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseDataProviderConfiguration {

    @Bean
    public AccountDatabaseDataProvider accountDatabaseDataProvider(AccountMongoRepository accountMongoRepository) {
        return new AccountDatabaseDataProvider(accountMongoRepository);
    }
}