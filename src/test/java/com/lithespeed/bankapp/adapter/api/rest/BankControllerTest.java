package com.lithespeed.bankapp.adapter.api.rest;

import com.lithespeed.bankapp.domain.Bank;
import com.lithespeed.bankapp.domain.Deposit;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BankControllerTest {

    BankController bankController;
    @Before
    public void before() {
        bankController = new BankController();
    }

    @Test
    public void itDeposits() {
        Bank bank = mock(Bank.class);
        ReflectionTestUtils.setField(bankController, "bank", bank);
        Deposit deposit = new Deposit(20);
        when(bank.getBalance()).thenReturn(20);
        bankController.deposit(deposit);
        assertThat(bankController.balance().getAmount(), is(20));

    }
}