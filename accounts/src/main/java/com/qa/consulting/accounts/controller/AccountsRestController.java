package com.qa.consulting.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.consulting.accounts.model.Account;
import com.qa.consulting.accounts.service.AccountService;

@RestController
@RequestMapping("/account-project/rest")
public class AccountsRestController {
	
	@Autowired
	private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccount() {
        return accountService.getAllAccounts();
    }

}
