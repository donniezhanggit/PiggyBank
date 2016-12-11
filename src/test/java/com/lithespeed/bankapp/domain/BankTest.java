package com.lithespeed.bankapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class BankTest {

    Bank subject;

    @Before
    public void before() {
        subject = new Bank();
    }

    @Test
    public void itDepositsMoney() {
        subject.deposit(20);
        assertThat(subject.getBalance(), is(20));
    }
}