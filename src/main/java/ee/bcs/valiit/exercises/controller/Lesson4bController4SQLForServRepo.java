package ee.bcs.valiit.exercises.controller;


import ee.bcs.valiit.exercises.service.Lesson4bService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class Lesson4bController4SQLForServRepo {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    @Autowired
    private Lesson4bService bankAccountService;


    //URL: http://localhost:8080/createaccount4/EE0011111/10000
    @PostMapping("createaccount4/{accountnumber}/{balance}")
    public void createAccount(@PathVariable("accountnumber") String accountNr, @PathVariable("balance") Double balance) {
        bankAccountService.createAccount(accountNr, balance);
    }

    //URL: http://localhost:8080/getbalance4/EE0011111
    @GetMapping("getbalance4/{accountnumber}")
    public Double getBalance(@PathVariable("accountnumber") String accountNr) {
        return bankAccountService.getBalance(accountNr);
    }

    //URL: http://localhost:8080/deposit4/EE0011111/1000
    @PutMapping("deposit4/{accountnumber}/{depositamount}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("depositamount") Double amount) {
        return bankAccountService.deposit(accountNr, amount);
    }

    //URL: http://localhost:8080/withdraw4/EE0011111/1000
    @PutMapping("withdraw4/{accountnumber}/{withdrawamount}")
    public String withdrawMoney(@PathVariable("accountnumber") String accountNr, @PathVariable("withdrawamount") Double amount) {
        return bankAccountService.withdrawMoney(accountNr, amount);
    }

    //URL: http://localhost:8080/transfer4/EE0011111/EE003344680/200
    @PutMapping("transfer4/{fromaccountnumber}/{toaccountnumber}/{amount}")
    public String transfer(@PathVariable("fromaccountnumber") String fromAccountNr, @PathVariable("toaccountnumber") String toAccountNr, @PathVariable("amount") Double amount) {
        return bankAccountService.transfer(fromAccountNr, toAccountNr, amount);
    }
}
