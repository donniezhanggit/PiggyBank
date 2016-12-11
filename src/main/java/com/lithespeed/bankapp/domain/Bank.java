package com.lithespeed.bankapp.domain;

import org.springframework.stereotype.Service;

@Service
public class Bank {

    private int balance = 0;

    public int deposit(int amount) {
        balance += amount;
        System.out.println("New balance is: " + balance);
        return balance;
    }

    public int getBalance() {
        return balance;
    }
}
