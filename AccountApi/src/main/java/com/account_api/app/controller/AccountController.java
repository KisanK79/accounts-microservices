package com.account_api.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.account_api.app.models.Account;
import com.account_api.app.models.Transaction;
import com.account_api.app.services.AccountService;



@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	 
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccounts(@RequestParam int page,int size) {
		return accountService.getAccounts(page,size);
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account>  getAccountById(@PathVariable int id) {
		return accountService.getAccountById(id);
	}	
	
	@PostMapping("/transaction")
	public ResponseEntity<Object> addTransaction(@RequestBody Transaction transaction) {
		return accountService.saveTransaction(transaction);
	}
	
	@PutMapping("/accounts")
	public ResponseEntity<? extends Object> updateAccounts(@RequestBody List<Account> accounts) {
		return accountService.updateAccounts(accounts);
	}
}
