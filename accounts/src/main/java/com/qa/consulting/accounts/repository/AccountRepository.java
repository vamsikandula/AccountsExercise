package com.qa.consulting.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.consulting.accounts.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
