package com.account_core.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account_core.app.models.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
