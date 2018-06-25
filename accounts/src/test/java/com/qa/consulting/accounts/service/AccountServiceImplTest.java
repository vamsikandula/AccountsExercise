package com.qa.consulting.accounts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Optional;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.consulting.accounts.model.Account;
import com.qa.consulting.accounts.repository.AccountRepository;

@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

	@TestConfiguration
	static class AccountServiceImplTestContextConfiguration{	 	
			
		@Bean
		public AccountService accountService() {
				return new AccountServiceImpl();
			}		
	}
	
	@Autowired
	private AccountService accountService;
	
	@MockBean
	private AccountRepository accountRepository; 
	
	private final String FIRST_NAME = "Adrian";
	private final String LAST_NAME = "Cox";
	private final String NON_FIRST_NAME = "James";
	
	@Before
	public void setup() {
		Account testAccount = new Account();
		testAccount.setFirstName(FIRST_NAME);
		testAccount.setLastName(LAST_NAME);		
		testAccount.setAccountNumber(1234);		
		
		
		Mockito.<Optional<Account>>when(accountRepository.findById(testAccount.getId())).thenReturn(Optional.of(testAccount)) ;		
		Mockito.when(accountRepository.findByFirstName(testAccount.getFirstName())).thenReturn(Optional.of(new Account()));
		
	}
	
	
	@Test
    public void whenValidId_thenEmployeeShouldBeFound() {
        Optional<Account> fromDb = accountService.getAccountById(1);
        assertThat(fromDb.isPresent());
        verifyFindByIdIsCalledOnce();
    }

    @Test
    public void whenInValidId_thenEmployeeShouldNotBeFound() {
    	Optional<Account> fromDb = accountService.getAccountById(-99);
        verifyFindByIdIsCalledOnce();
        assertThat(fromDb).isEmpty();
    }
    
	@Test
    public void whenValidFirstName_thenAccountShouldExist() {
		
        Optional<Account>  doesAccountExist = accountService.getAccountByFirstName(FIRST_NAME);
        assertThat(doesAccountExist.isPresent()).isEqualTo(true);

        verifyFindByFirstNameIsCalledOnce(FIRST_NAME);
    }

    @Test
    public void whenNonExistingName_thenEmployeeShouldNotExist() {
    	Optional<Account>  doesAccountExist = accountService.getAccountByFirstName(NON_FIRST_NAME);
        assertThat(doesAccountExist.isPresent()).isEqualTo(false);

        verifyFindByFirstNameIsCalledOnce(NON_FIRST_NAME);
    }

      
    private void verifyFindByFirstNameIsCalledOnce(String name) {
        Mockito.verify(accountRepository, VerificationModeFactory.times(1)).findByFirstName(name);
        Mockito.reset(accountRepository);
    }
    
        
    private void verifyFindByIdIsCalledOnce() {
        Mockito.verify(accountRepository, VerificationModeFactory.times(1)).findById(Mockito.anyInt());
        Mockito.reset(accountRepository);
    }
	
	
}
