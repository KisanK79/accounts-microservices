package com.account_core.app.services;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.account_core.app.controller.AccountController;
import com.account_core.app.dto.AccountDto;
import com.account_core.app.dto.TransactionDto;
import com.account_core.app.models.Account;
import com.account_core.app.models.AccountTrans;
import com.account_core.app.repository.AccountRepo;
import com.account_core.app.repository.AccountTransRepo;

@Service
public class AccountService {
	@Autowired
	AccountRepo accountRepo;

	@Autowired
	AccountTransRepo transactionRepo;
	
	@Autowired
	ModelMapper mapper;
	Logger logger = LoggerFactory.getLogger(AccountController.class);

	public ResponseEntity<List<AccountDto>> getAllAcounts(Pageable pageable) {
		Page<Account> accounts = accountRepo.findAll(pageable);
		List<AccountDto> accountDtos = accounts.stream().map(account -> accountToAccountDto(account))
				.collect(Collectors.toList());
		return new  ResponseEntity<List<AccountDto>>(accountDtos,HttpStatus.OK);
	}

	public ResponseEntity<AccountDto> getAccountById(int id) {
		try {
			Account account = accountRepo.getOne(id);
			return new ResponseEntity<AccountDto>(accountToAccountDto(account),HttpStatus.OK);
		} catch (EntityNotFoundException | MappingException e) {
			logger.error(e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	public  ResponseEntity<TransactionDto> saveTransaction(AccountTrans transaction) {
		transaction.setAccount(new Account(transaction.getAccountId()));
		AccountTrans trans = transactionRepo.save(transaction); 
		return ResponseEntity.ok(mapper.map(trans, TransactionDto.class));

	}

	public ResponseEntity<List<TransactionDto>> getTransactions() {
		List<AccountTrans> trans = transactionRepo.findAll();
		List<TransactionDto> transDtos = trans.stream().map(t -> {
			return mapper.map(t, TransactionDto.class);
		}).collect(Collectors.toList());

		return new ResponseEntity<List<TransactionDto>>(transDtos,HttpStatus.OK);
	}

	private AccountDto accountToAccountDto(Account account) {
		AccountDto accountDto = mapper.map(account, AccountDto.class);
		accountDto.setCurrentBalance(getcurrentBalance(account.getAccountTras(), account.getOpeningBalance()));
		return accountDto;
	}

	private int getcurrentBalance(List<AccountTrans> accountTras, int openingBalance) {
		int currentBalance = openingBalance;
		for (AccountTrans transaction : accountTras) {
			if (transaction.getTransType().equals("debit"))
				currentBalance -= transaction.getTransAmmount();
			else
				currentBalance += transaction.getTransAmmount();
		}
		return currentBalance;
	}

	public ResponseEntity<String> updateAccounts(List<AccountDto> accountDtos) {
		List<Account> Oldaccounts = accountRepo.findAll();
		List<AccountDto> OldAccountDtos = Oldaccounts.stream().map(account -> mapper.map(account, AccountDto.class))
				.collect(Collectors.toList());
//		accountDtos.forEach(newAccount -> {
//			OldAccountDtos.forEach(oldAccount -> {
//				if (newAccount.getAccountId() == oldAccount.getAccountId() && ! newAccount.equals(oldAccount)) {
//					logger.info("put request is called for account with id " + newAccount.getAccountId());
//					accountRepo.save(mapper.map(newAccount, Account.class));
//				}
//
//			});
//		});
		
		accountDtos.forEach(newAccount -> {
			boolean isFound = OldAccountDtos.stream()
					.anyMatch(oldAccount -> newAccount.getAccountId() == oldAccount.getAccountId()
							&& !newAccount.equals(oldAccount));
			if(isFound)
				accountRepo.save(mapper.map(newAccount, Account.class));		
		});
		
		return new ResponseEntity<String>("accounts updated successsfully", HttpStatus.OK);

	}

}
