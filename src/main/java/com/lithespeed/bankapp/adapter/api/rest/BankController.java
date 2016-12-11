package com.lithespeed.bankapp.adapter.api.rest;


import com.lithespeed.bankapp.domain.Bank;
import com.lithespeed.bankapp.domain.Deposit;
import com.lithespeed.bankapp.domain.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    Bank bank;

    @RequestMapping(value = "/deposit",
    method = RequestMethod.POST)
    public @ResponseBody Money deposit(@RequestBody Deposit deposit) {
        bank.deposit(deposit.getDepositAmount());
        Money money = new Money();
        money.setAmount(bank.getBalance());
        return money;
    }

    @RequestMapping(value = "/balance",
    method = RequestMethod.GET)
    public @ResponseBody Money balance() {
        Money money = new Money();
        money.setAmount(bank.getBalance());
        return money;
    }
}
