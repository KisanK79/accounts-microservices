package com.account_core.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account_core.app.models.AccountTrans;

public interface AccountTransRepo extends JpaRepository<AccountTrans, Integer> {

}
