package ee.bcs.valiit.lessons;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4bController2 {
    private static Map<String, BankAccount> accountBalanceMap = new HashMap<>();


    @GetMapping("bank/createaccount2")
    public void createAccount(@RequestParam("accountnumber") String accountNr, @RequestParam("balance") Double balance, @RequestParam("name") String ownerName) {
        BankAccount account = new BankAccount();
        account.setAccountNr(accountNr);
        account.setOwnerName(ownerName);
        account.setBalance(balance);
        account.setLocked(false);
        accountBalanceMap.put(accountNr, account);
    }


    @GetMapping("bank/getbalance2/{accountnumber}")
    public String getBalance(@PathVariable("accountnumber") String accountNr) {
        return "The balance is: " + accountBalanceMap.get(accountNr).getBalance();
    }


    @PutMapping("bank/deposit/{accountnumber}/{deposit}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("deposit") Double amount) {
        if (amount > 0) {
            // Double currentBalance = accountBalanceMap.get(accountNr).getBalance();
            Double newBalance = accountBalanceMap.get(accountNr).getBalance() + amount;
            return "Money has been added to your account: " + accountBalanceMap.put(accountNr, newBalance);
        } else {
            return "Invalid request";
        }
    }


    @PutMapping("bank/withdraw/{accountnumber}/{withdraw}")
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


    @PutMapping("bank/{fromaccount}/{toaccount}/{amount}")
    public String transfer(@PathVariable("fromaccount") String fromAccountNr, @PathVariable("toaccount") String toAccountNr, @PathVariable("amount") Double amount) {
        if (amount > 0) {
            double fromAccountBalance = accountBalanceMap.get(fromAccountNr).getBalance();
            if (fromAccountBalance < amount) {
                return "Not enough money on your account";
            } else {
                double toAccountBalance = accountBalanceMap.get(toAccountNr).getBalance();
                accountBalanceMap.put(fromAccountNr, fromAccountBalance - amount);
                return "New balance is: " + accountBalanceMap.put(toAccountNr, toAccountBalance + amount);
            }
        } else {
            return "Invalid request";
        }
    }

    @PutMapping("sample/bank/account/{accountNumber}/lock")
    public String lock(@PathVariable("accountNumber") String accountNr) {
        return null;
    }

    @PutMapping("sample/bank/account/{accountNumber}/unlock")
    public String unlock(@PathVariable("accountNumber") String accountNr) {
        return null;
    }
}
