package com.account_api.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.account_api.app.models.Account;
import com.account_api.app.models.Transaction;

@Service
public class AccountService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	ExecutorService service;

	public ResponseEntity<List<Account>> getAccounts(int page, int size) {
		try {
			Future<Account[]> accounts = service.submit(() -> restTemplate.getForObject(
					"http://localhost:8081/accountDetails?page=" + page + "&size=" + size, Account[].class));

//			Account[] accounts = restTemplate.getForObject(
//					"http://localhost:8081/accountDetails?page=" + page + "&size=" + size, Account[].class);
			List<Account> accountList = Arrays.asList(accounts.get());
			return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<List<Account>>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Account> getAccountById(int id) {
		try {
			Future<Account> account = service.submit(
					() -> restTemplate.getForObject("http://localhost:8081/accountDetails/" + id, Account.class));
			// Account account=
			// restTemplate.getForObject("http://localhost:8081/accountDetails/" + id,
			// Account.class);
			return ResponseEntity.ok(account.get());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<Object> saveTransaction(Transaction transaction) {
		try {
			Future<Transaction> trans = service.submit(() -> restTemplate
					.postForObject("http://localhost:8081/transaction", transaction, Transaction.class));
//			Transaction trans = restTemplate.postForObject("http://localhost:8081/transaction", transaction,
//					Transaction.class);
			return ResponseEntity.ok(trans.get());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("server error while making request");
		}
	}

	public ResponseEntity<String> updateAccounts(List<Account> accounts) {
		try {
			HttpEntity<List<Account>> httpAccounts = new HttpEntity<List<Account>>(accounts);
			Future<String> response = service.submit(() -> restTemplate
					.exchange("http://localhost:8081/accountDetails", HttpMethod.PUT, httpAccounts, String.class)
					.getBody());

//			String response = restTemplate
//					.exchange("http://localhost:8081/accountDetails", HttpMethod.PUT, httpAccounts, String.class)
//					.getBody();
			return ResponseEntity.ok(response.get());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("server error while making request");
		}
	}
}
