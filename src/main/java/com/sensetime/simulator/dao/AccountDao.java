package com.sensetime.simulator.dao;


import com.sensetime.simulator.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by songqiu on 2018/12/10
 */
public interface AccountDao extends JpaRepository<Account,Long> {

    Account findAccountByname(String username);
}
