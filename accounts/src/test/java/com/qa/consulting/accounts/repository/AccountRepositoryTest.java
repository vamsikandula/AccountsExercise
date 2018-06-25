package com.qa.consulting.accounts.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.qa.consulting.accounts.model.Account;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {


	private final String FIRST_NAME = "Jon";
	
	// loading 3 accounts via data.sql 
	
    @Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void whenFindAll_thenReturnAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		assertEquals(3,accounts.size());
	}

}
