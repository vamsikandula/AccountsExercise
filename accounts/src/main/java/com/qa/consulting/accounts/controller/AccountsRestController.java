package com.qa.consulting.accounts.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.qa.consulting.accounts.exception.AccountNotFoundException;
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
    
    @GetMapping("/accounts/{id}")
    public Optional<Account> retriveAccountById(@PathVariable int id) {
        Optional<Account> accountById = accountService.getAccountById(id);
        if(!accountById.isPresent())
        	throw new AccountNotFoundException("Account with id " + id + " not present");        	
		return accountById;
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
    
    @DeleteMapping("/accounts/{id}")
    public Map<String, String> deleteAccount(@PathVariable int id) {
    	
    	Optional<Account> accountById = accountService.getAccountById(id);
	        if(!accountById.isPresent()) {
	        	throw new AccountNotFoundException("Account with id " + id + " not present");
	        }       	
        
    	accountService.deleteAccount(id);
    	
    	return Collections.singletonMap("message", "Account successfully deleted");
    }
    
	

}
