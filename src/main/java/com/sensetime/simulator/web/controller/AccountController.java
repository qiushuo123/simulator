package com.sensetime.simulator.web.controller;

import com.sensetime.simulator.entity.Account;
import com.sensetime.simulator.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
/**
 * Created by songqiu on 2018/12/10
 */

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;
    @ApiOperation(value = "账户列表", notes = "账户列表")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Account> getAccount() {
        List<Account> accounts = accountService.findAll();
        return accounts;
    }

    @ApiOperation(value = "创建账户", notes = "创建账户")

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Account postAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);

    }

    @ApiOperation(value = "获账户详细信息", notes = "根据url的id来获取详细信息")

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Account putAccount(@PathVariable Long id, @RequestBody Account account) {
        Account user1 = new Account();
        user1.setAccount(account.getAccount());
        user1.setPassword(account.getPassword());
        user1.setId(id);
        return accountService.updateAccount(user1);

    }

    @ApiOperation(value = "删除账户", notes = "根据url的id来指定删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "success";
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String jsonTest() {
        return " hi you!";
    }
}
