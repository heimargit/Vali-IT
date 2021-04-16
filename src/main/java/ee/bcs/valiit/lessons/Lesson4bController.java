package ee.bcs.valiit.lessons;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4bController {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    //URL: http://localhost:8080/createaccount/{accountnumber}/{balance}
    @PostMapping("createaccount/{accountnumber}/{balance}")
    public void createAccount(@PathVariable("accountnumber") String accountNr, @PathVariable("balance") Double balance) {
        accountBalanceMap.put(accountNr, balance);
    }

    //URL: http://localhost:8080/getbalance/{accountnumber}
    @GetMapping("getbalance/{accountnumber}")
    public String getBalance(@PathVariable("accountnumber") String accountNr) {
        return "The balance is: " + accountBalanceMap.get(accountNr);
    }

    //URL: http://localhost:8080/deposit/{accountnumber}/{depositamount}
    @PutMapping("deposit/{accountnumber}/{depositamount}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("depositamount") Double amount) {
        if (amount > 0) {
            Double currentBalance = accountBalanceMap.get(accountNr);
            Double newBalance = currentBalance + amount;
            accountBalanceMap.put(accountNr, newBalance);
            return "The new balance is: " + accountBalanceMap.get(accountNr);
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/withdraw/{accountnumber}/{withdrawamount}
    @PutMapping("withdraw/{accountnumber}/{withdrawamount}")
    public String withdrawMoney(@PathVariable("accountnumber") String accountNr, @PathVariable("withdrawamount") Double amount) {
        if (amount > 0) {
            Double currentBalance = accountBalanceMap.get(accountNr);
            Double newBalance = currentBalance - amount;
            if (newBalance >= 0) {
                accountBalanceMap.put(accountNr, newBalance);
                return "The new balance is: "+ accountBalanceMap.get(accountNr);
            } else {
                return "Invalid request";
            }
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/transfer/{fromaccount}/{toaccount}/{amount}
    @PutMapping("transfer/{fromaccount}/{toaccount}/{amount}")
    public String transfer(@PathVariable("fromaccount") String fromAccountNr, @PathVariable("toaccount") String toAccountNr, @PathVariable("amount") Double amount) {

        if (amount > 0) {
            Double fromAccountBalance = accountBalanceMap.get(fromAccountNr);
            if (fromAccountBalance < amount) {
                return "Not enough money on your account";
            } else {
                Double toAccountBalance = accountBalanceMap.get(toAccountNr);
                accountBalanceMap.put(fromAccountNr, fromAccountBalance - amount);
                accountBalanceMap.put(toAccountNr, toAccountBalance + amount);
                return "New balance is: " + accountBalanceMap.get(toAccountNr);
            }
        } else {
            return "Invalid request";
        }
    }
}
