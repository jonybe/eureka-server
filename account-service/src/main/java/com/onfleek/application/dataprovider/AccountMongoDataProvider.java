package com.onfleek.application.dataprovider;

import com.onfleek.application.core.usecase.CreateAccount;
import com.onfleek.application.core.usecase.GetAccount;

import java.util.Optional;

public class AccountMongoDataProvider implements GetAccount, CreateAccount {

    private final AccountMongoRepository accountMongoRepository;

    public AccountMongoDataProvider(AccountMongoRepository accountMongoRepository) {
        this.accountMongoRepository = accountMongoRepository;
    }

    @Override
    public com.onfleek.application.core.entity.Account createAccount(com.onfleek.application.core.entity.Account account) {
        return mapAccount(accountMongoRepository.insert(mapAccount(account)));
    }

    @Override
    public Optional<com.onfleek.application.core.entity.Account> getAccount(String username) {
        Account result = accountMongoRepository.findByUsername(username);

        return Optional.of(mapAccount(result));

    }

    private com.onfleek.application.core.entity.Account mapAccount(Account account) {
        com.onfleek.application.core.entity.Account result = new com.onfleek.application.core.entity.Account();
        result.setId(account.getId());
        result.setUsername(account.getUsername());
        result.setGivenName(account.getGivenName());
        result.setSurName(account.getSurName());
        result.setRole(account.getRole());
        return result;
    }


    private Account mapAccount(com.onfleek.application.core.entity.Account account) {
        Account result = new Account();
        result.setId(account.getId());
        result.setUsername(account.getUsername());
        result.setGivenName(account.getGivenName());
        result.setSurName(account.getSurName());
        result.setRole(account.getRole());
        return result;
    }
}
