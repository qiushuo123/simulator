package com.sensetime.simulator.service;

import com.sensetime.simulator.dao.AccountDao;
import com.sensetime.simulator.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songqiu on 2018/12/10
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountRepository;

    public Account findAccountByName(String username){
        return accountRepository.findAccountByname(username);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account findAccountById(long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account updateAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

}
