package ee.bcs.valiit.lessons;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4bController {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    //URL: localhost:8080/bank/createaccount/{accountnumber}/{balance}
    @GetMapping("bank/createaccount/{accountnumber}/{balance}")
    public void createAccount(@PathVariable("accountnumber") String accountNr, @PathVariable("balance") Double balance) {
        accountBalanceMap.put(accountNr, balance);
    }

    //URL: localhost:8080/bank/getbalance/{accountnumber}
    @GetMapping("bank/getbalance/{accountnumber}")
    public String getBalance(@PathVariable("accountnumber") String accountNr) {
        return "The balance is: " + accountBalanceMap.get(accountNr);
    }

    //URL: localhost:8080/bank/deposit/{accountnumber}/{depositamount}
    @PutMapping("bank/deposit/{accountnumber}/{depositamount}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("depositamount") Double amount) {
        if (amount > 0) {
            Double currentBalance = accountBalanceMap.get(accountNr);
            Double newBalance = currentBalance + amount;
            return "Money has been added to your account: " + accountBalanceMap.put(accountNr, newBalance);
        } else {
            return "Invalid request";
        }
    }

    //URL: localhost:8080/bank/withdraw/{accountnumber}/{withdrawamount}
    @PutMapping("bank/withdraw/{accountnumber}/{withdrawamount}")
    public String withdrawMoney(@PathVariable("accountnumber") String accountNr, @PathVariable("withdrawamount") Double amount) {
        if (amount > 0) {
            Double currentBalance = accountBalanceMap.get(accountNr);
            Double newBalance = currentBalance - amount;
            if (newBalance >= 0) {
                return "Money has been withdrawn from your account: " + accountBalanceMap.put(accountNr, newBalance);
            } else {
                return "Invalid request";
            }
        } else {
            return "Invalid request";
        }
    }

    //URL: localhost:8080/bank/{fromaccount}/{toaccount}/{amount}
    @PutMapping("bank/{fromaccount}/{toaccount}/{amount}")
    public String transfer(@PathVariable("fromaccount") String fromAccountNr, @PathVariable("toaccount") String toAccountNr, @PathVariable("amount") Double amount) {
        if (amount > 0) {
            double fromAccountBalance = accountBalanceMap.get(fromAccountNr);
            if (fromAccountBalance < amount) {
                return "Not enough money on your account";
            } else {
                double toAccountBalance = accountBalanceMap.get(toAccountNr);
                accountBalanceMap.put(fromAccountNr, fromAccountBalance - amount);
                return "New balance is: " + accountBalanceMap.put(toAccountNr, toAccountBalance + amount);
            }
        } else {
            return "Invalid request";
        }
    }
}
