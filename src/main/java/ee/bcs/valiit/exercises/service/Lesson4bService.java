package ee.bcs.valiit.exercises.service;


import ee.bcs.valiit.exercises.hibernate.Account;
import ee.bcs.valiit.exercises.hibernate.AccountHibernateRepository;
import ee.bcs.valiit.exercises.repository.Lesson4bRepository;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;


@Service
public class Lesson4bService {

    @Autowired
    private Lesson4bRepository bankAccountRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountHibernateRepository hibernateRepository;


    public void createAccount(String accountNr, String ownerName) {
        bankAccountRepository.createAccount(accountNr, ownerName, 0.0);
    }

    public Double getBalance(String accountNr) {
        Account account = hibernateRepository.getOne(accountNr); //hibernate meetodi abil
        return account.getBalance();
        // return bankAccountRepository.getBalance(accountNr);
    }

    public String deposit(String accountNr, Double amount) {
        if (amount < 0) {
            throw new SampleApplicationException("Negative amount request is not allowed");
        }
        Account account = hibernateRepository.getOne(accountNr);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        hibernateRepository.save(account);
        return "New balance is: " + balance;

//        Double balance = bankAccountRepository.getBalance(accountNr);
//        Double newBalance = balance + amount;
//        bankAccountRepository.updateBalance(accountNr, newBalance);
//        return "New balance is: " + newBalance;
    }

    public String withdrawMoney(String accountNr, Double amount) {
        if (amount < 0) {
            throw new SampleApplicationException("Negative amount request is not allowed");
        }
        Double currentBalance = bankAccountRepository.getBalance(accountNr);
        if (currentBalance <= 0 || currentBalance < amount) {
            throw new SampleApplicationException("Current balance is negative");
        }
        Double newBalance = currentBalance - amount;
        bankAccountRepository.updateBalance(accountNr, newBalance);
        return "New balance is: " + newBalance;
    }

    public String transfer(String fromAccountNr, String toAccountNr, Double amount) {
        if (amount < 0) {
            throw new SampleApplicationException("Negative amount request is not allowed");
        }
        Double currentFromBalance = bankAccountRepository.getBalance(fromAccountNr);
        Double currentToBalance = bankAccountRepository.getBalance(toAccountNr);
        if (currentFromBalance < amount || currentFromBalance <= 0) {
            throw new SampleApplicationException("Not enough balance");
        }
        Double newFromBalance = currentFromBalance - amount;
        Double newToBalance = currentToBalance + amount;
        bankAccountRepository.updateBalance(fromAccountNr, newFromBalance);
        bankAccountRepository.updateBalance(toAccountNr, newToBalance);
        //bankAccountRepository.transfer(fromAccountNr, toAccountNr, newToBalance);
        return "Transaction was successful.";
    }

    public String deleteAccount(String accountNr, String ownerName) {
        bankAccountRepository.deleteAccount(accountNr, ownerName);
        return "The account has been deleted";
    }
}