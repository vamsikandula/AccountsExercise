package com.qa.consulting.accounts.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    
    @PostMapping("/accounts")
    public ResponseEntity<Object> createAccount(@Valid @RequestBody Account account) {
        
        Account saved = accountService.save(account);        
        URI location = ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{id}")
        		.buildAndExpand(saved.getId()).toUri();
        
        return ResponseEntity.created(location).body("Account has been successfully added");
        
    }
    

}
