package ee.bcs.valiit.lessons;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4bController1_Postman {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();


    //URL: http://localhost:8080/createaccount1/?accountnumber=EE12345&balance=100
    @PostMapping("createaccount1")
    public void createAccount(@RequestParam("accountnumber") String accountNr, @RequestParam("balance") Double balance) {
        accountBalanceMap.put(accountNr, balance);
    }

    //URL: http://localhost:8080/getbalance1/EE12345
    @GetMapping("getbalance1/{accountnumber}")
    public String getBalance(@PathVariable("accountnumber") String accountNr) {
        return "The balance is: " + accountBalanceMap.get(accountNr) + " €";
    }


    //URL: http://localhost:8080/deposit1/EE12345/1000
    @PutMapping("deposit1/{accountnumber}/{deposit}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("deposit") Double amount) {
        if (amount > 0) {
                Double currentBalance = accountBalanceMap.get(accountNr);
                Double newBalance = currentBalance + amount;
                accountBalanceMap.put(accountNr, newBalance);

            return amount + " € has been added to your account. New balance is: " + accountBalanceMap.get(accountNr) + " €";
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/withdraw1/EE12345/1000
    @PutMapping("withdraw1/{accountnumber}/{withdraw}")
    public String withdrawMoney(@PathVariable("accountnumber") String accountNr, @PathVariable("withdraw") Double amount) {
        if (amount > 0) {
            Double currentBalance = accountBalanceMap.get(accountNr);
            Double newBalance = currentBalance - amount;
            if (newBalance >= 0) {
                accountBalanceMap.put(accountNr, newBalance);
                return amount + " € has been withdrawn from your account. New balance is: " + accountBalanceMap.get(accountNr) + " €";
            } else {
                return "Invalid request. Account has not enough money";
            }
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/transfer1/EE12345/{toaccountnumber}/10
    @PutMapping("transfer1/{fromaccountnumber}/{toaccountnumber}/{amount}")
    public String transfer(@PathVariable("fromaccountnumber") String fromAccountNr, @PathVariable("toaccountnumber") String toAccountNr, @PathVariable("amount") Double amount) {

        if (amount > 0) {
            Double fromBalance = accountBalanceMap.get(fromAccountNr);

            if (fromBalance < amount) {
                return "Account has not enough money";
            } else {
                fromBalance = fromBalance - amount;
                accountBalanceMap.put(fromAccountNr, fromBalance);

                Double toBalance = accountBalanceMap.get(toAccountNr);
                toBalance = toBalance + amount;
                accountBalanceMap.put(toAccountNr, toBalance);

                return "Transaction was successful. Account's new balance is: " + accountBalanceMap.get(fromBalance) + " €";
            }
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/lockaccount1/{toaccountnumber}
    @PutMapping("lockaccount1/{accountNumber}")
    public String lock(@PathVariable("accountNumber") String accountNr) {
        accountBalanceMap.get(accountNr);
        return "Account has been locked";
    }

    //URL: http://localhost:8080/unlockaccount1/{toaccountnumber}
    @PutMapping("unlockaccount1/{accountNumber}")
    public String unlock(@PathVariable("accountNumber") String accountNr) {
        accountBalanceMap.get(accountNr);
        return "Account has been unlocked";
    }

}
