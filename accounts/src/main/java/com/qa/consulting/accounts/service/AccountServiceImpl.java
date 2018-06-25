package com.qa.consulting.accounts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.consulting.accounts.model.Account;
import com.qa.consulting.accounts.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Account> getAccountById(int id) {
		return accountRepository.findById(id);
	}

	@Override
	public Optional<Account> getAccountByFirstName(String firstName) {
		return accountRepository.findByFirstName(firstName);
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub

	}
}
