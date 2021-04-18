package ee.bcs.valiit.lessons;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4bController2 {
    private static Map<String, BankAccount> accountBalanceMap = new HashMap<>();


    //URL: http://localhost:8080/createaccount2/?accountnumber=EE12345&?balance=0&?name=Mari
    @GetMapping("createaccount2")
    public void createAccount(@RequestParam("accountnumber") String accountNr, @RequestParam("balance") Double balance, @RequestParam("name") String ownerName) {
        BankAccount account = new BankAccount();
        account.setAccountNr(accountNr);
        account.setOwnerName(ownerName);
        account.setBalance(balance);
        account.setLocked(false);
        accountBalanceMap.put(accountNr, account);
    }

    //URL: http://localhost:8080/getbalance2/{accountnumber}
    @GetMapping("getbalance2/{accountnumber}")
    public String getBalance(@PathVariable("accountnumber") String accountNr) {
        return "The balance is: " + accountBalanceMap.get(accountNr).getBalance();
    }

/*

    //URL: http://localhost:8080/deposit/{accountnumber}/{deposit}
    @PutMapping("deposit/{accountnumber}/{deposit}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("deposit") Double amount) {
        if (amount > 0) {
            // Double currentBalance = accountBalanceMap.get(accountNr).getBalance();
            Double newBalance = accountBalanceMap.get(accountNr).getBalance() + amount;
            return "Money has been added to your account: " + accountBalanceMap.put(accountNr, newBalance);
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/withdraw/{accountnumber}/{withdraw}/{amount}
    @PutMapping("withdraw/{accountnumber}/{withdraw}")
    public String withdrawMoney(@PathVariable("accountnumber") String accountNr, @PathVariable("withdraw") Double amount) {
        if (amount > 0) {
            Double currentBalance = accountBalanceMap.get(accountNr).getBalance();
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

        //URL: http://localhost:8080/transfer2/{accountnumber}/{amount}
    @PutMapping("transfer2/{accountnumber}/{amount}")
    public String transfer(@PathVariable("accountnumber") String accountNr, @PathVariable("amount") Double amount) {

        if (amount > 0) {
            Double balance = accountBalanceMap.get(accountNr);
            if (balance < amount) {
                return "Not enough money on your account";
            } else {
                balance = balance - amount;
                accountBalanceMap.put(accountNr, balance);
                return "New balance is: " + balance;
            }
        } else {
            return "Invalid request";
        }
    }



    @PutMapping("lock/account/{accountNumber}/lock")
    public String lock(@PathVariable("accountNumber") String accountNr) {
        return null;
    }

    @PutMapping("unlock/account/{accountNumber}/unlock")
    public String unlock(@PathVariable("accountNumber") String accountNr) {
        return null;
    }

 */
}
