package com.qa.consulting.accounts.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.qa.consulting.accounts.AccountsApplication;
import com.qa.consulting.accounts.model.Account;
import com.qa.consulting.accounts.repository.AccountRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = AccountsApplication.class)
@AutoConfigureMockMvc
public class AccountRestControllerIT {

	 @Autowired
	    private MockMvc mvc;

	    @Autowired
	    private AccountRepository repository;

	    
	    @Test
	    public void whenValidInput_thenCreateAccount() throws IOException, Exception {
	        Account bob = new Account("Tom", "Bew",7657);
	        mvc.perform(post("/account-project/rest/accounts")
	        		.contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(bob)))
	                .andExpect(status().isCreated())
	                .andExpect(jsonPath("$").value("Account has been successfully added"));
	    }

	    @Test
	    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
	
	        
	        mvc.perform(get("/account-project/rest/accounts").contentType(MediaType.APPLICATION_JSON))
	          .andDo(print())
	          .andExpect(status().isOk())
	          .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	          .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
	          .andExpect(jsonPath("$[0].firstName", is("Jon")))
	          .andExpect(jsonPath("$[1].firstName", is("Andrew")));
	        
	    }
	    
	    
	    @Test
	    public void givenValidUserId_whenDeleteUser_thenSuccessfulDelete() throws IOException, Exception {
	        
	        mvc.perform(delete("/account-project/rest/accounts/{id}",2))	        		
	                .andExpect(status().is2xxSuccessful())
	                .andExpect(jsonPath("$.message").value("Account successfully deleted"));
	    }
	    




}
