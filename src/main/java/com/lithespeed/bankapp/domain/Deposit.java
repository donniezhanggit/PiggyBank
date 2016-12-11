package com.lithespeed.bankapp.domain;

public class Deposit {

    int depositAmount;

    public Deposit() {
    }

    public Deposit(int amount) {
        depositAmount = amount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

}
