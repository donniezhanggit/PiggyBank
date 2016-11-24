package com.lithespeed.bankapp.adapter.api.rest;


import com.lithespeed.bankapp.domain.Balance;
import com.lithespeed.bankapp.domain.Deposit;
import com.lithespeed.bankapp.domain.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    Balance balance;

    @RequestMapping(value = "/deposit",
    method = RequestMethod.POST)
    public @ResponseBody Money deposit(@RequestBody Deposit deposit) {
        balance.deposit(deposit.getDepositAmount());
        Money money = new Money();
        money.setAmount(balance.getBalance());
        return money;
    }

    @RequestMapping(value = "/balance",
    method = RequestMethod.GET)
    public @ResponseBody Money balance() {
        Money money = new Money();
        money.setAmount(balance.getBalance());
        return money;
    }
}
