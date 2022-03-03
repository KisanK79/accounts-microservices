package com.account_core.app.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.account_core.app.dto.AccountDto;
import com.account_core.app.dto.TransactionDto;
import com.account_core.app.models.AccountTrans;
import com.account_core.app.repository.AccountTransRepo;
import com.account_core.app.services.AccountService;




@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	AccountTransRepo accountTrasRepo;

	@Autowired
	AccountService accountService;

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@GetMapping("hello")
	public String hello() {
		logger.error("error from java code");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
		return "kisan";
	}

	@GetMapping("/accountDetails")
	public ResponseEntity<List<AccountDto>> getAccountDetails(Pageable pageable) {
		return accountService.getAllAcounts(pageable);
	}

	@GetMapping("/accountDetails/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable int id) {
		return accountService.getAccountById(id);

	}

	@PostMapping("/transaction")
	public ResponseEntity<TransactionDto> saveTransaction(@RequestBody AccountTrans accountTrans) {
		return accountService.saveTransaction(accountTrans);
	}

	@PutMapping("/accountDetails")
	public ResponseEntity<String> updateAccounts(@RequestBody List<AccountDto> accounts) {
		List<AccountDto> accountDtos = accounts;
		return accountService.updateAccounts(accountDtos);
	}

	@GetMapping("/accountTras")
	public ResponseEntity<List<TransactionDto>> getAccountTras() {
		return accountService.getTransactions();

	}

	@PostMapping("/x")
	public String x(@RequestBody String x) {
		System.out.println(x);
		return "yes";
	}
}
