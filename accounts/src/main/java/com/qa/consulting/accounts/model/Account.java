package com.qa.consulting.accounts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Account {
		
		 	@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private int id;
		 	@Size(min=1, message="First Name should have atleast 1 character")
		    private String firstName;
		 	@Size(min=1, message="Last Name should have atleast 1 character")
		    private String lastName;
		 	@Positive
		    private int accountNumber;
		    
			public Account() {
				
			}
			
			public Account( String firstName, String lastName, int accountNumber) {
				super();
				this.firstName = firstName;
				this.lastName = lastName;
				this.accountNumber = accountNumber;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public int getAccountNumber() {
				return accountNumber;
			}

			public void setAccountNumber(int accountNumber) {
				this.accountNumber = accountNumber;
			}
			
}


