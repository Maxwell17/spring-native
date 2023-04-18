package com.example.springnative.repository;

import com.example.springnative.repository.domain.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findAll();

    Account findAccountByUsername(@Param("username") String username);

    Account findAccountByEmail(@Param("email") String email);

}
