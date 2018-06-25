package com.qa.consulting.accounts.service;

import java.util.List;
import java.util.Optional;

import com.qa.consulting.accounts.model.Account;

public interface AccountService {

	public List<Account> getAllAccounts();

	public Optional<Account> getAccountById(int id);

	public Optional<Account> getAccountByFirstName(String firstName);

	public Account save(Account account);

	public void deleteAccount(int id);

}
