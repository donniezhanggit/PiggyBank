package com.lithespeed.bankapp;

import com.lithespeed.bankapp.domain.Bank;
import com.lithespeed.bankapp.domain.Deposit;
import com.lithespeed.bankapp.domain.Money;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

@ContextConfiguration(classes = BankappApplication.class, loader = SpringBootContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTestsSteps {

    @LocalServerPort
    private int localPort;

    @Autowired
    private Bank bank;

    private RestTemplate restTemplate = new RestTemplate();
    private String server = "localhost";
    private String depositResource = "/api/deposit";
    private String balanceResource = "/api/balance";


    @Given("^an empty bank account$")
    public void an_empty_bank_account() throws Throwable {
        int balance = bank.getBalance();
        bank.deposit(0 - balance);
    }

    @When("^I deposit (\\d+)$")
    public void i_deposit(int depositAmount) throws Throwable {
        Deposit deposit = new Deposit(depositAmount);
        String url = buildDepositURI().toString();
        HttpEntity<Deposit> requestEntity = new HttpEntity<>(deposit);
        HttpEntity<Money> response = restTemplate.exchange(url, HttpMethod.POST,
                requestEntity, Money.class);

        assertThat(response, notNullValue());
    }

    @Then("^my balance is now (\\d+)$")
    public void my_balance_is_now(int currentBalance) throws Throwable {
        String url = buildBalanceURI().toString();
        HttpEntity<?> entity = new HttpEntity<>(null);
        HttpEntity<Money> response = restTemplate.exchange(url, HttpMethod.GET, entity, Money.class);

        assertThat(response.getBody().getAmount(), is(currentBalance));
    }

    private URI buildDepositURI() {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(server)
                .port(localPort)
                .path(depositResource)
                .build().toUri();
    }

    private URI buildBalanceURI() {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(server)
                .port(localPort)
                .path(balanceResource)
                .build().toUri();
    }
}
