package ee.bcs.valiit.lessons;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4bController {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    @Autowired // ehk Inversion of Control - vastutab, et objekte luua ja neid hallata; loome ühenduse andmebaasiga
    private NamedParameterJdbcTemplate jdbcTemplate; //klass, mida kasutame. @Autowired inistsialiseerib selle.


    //URL: http://localhost:8080/createaccount/EE003344680/300
    @PostMapping("createaccount/{accountnumber}/{balance}")
    public void createAccount(@PathVariable("accountnumber") String accountNr, @PathVariable("balance") Double balance) {
        String sql = "INSERT INTO account (account_number, balance) VALUES(:dbAccNo, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbAmount", balance);
        jdbcTemplate.update(sql, paramMap); //kahe muutuja kasutamine tähendab, et see meetod ei tagasta meile midagi
        //accountBalanceMap.put(accountNr, balance);
    }

    //URL: http://localhost:8080/getbalance/{accountnumber}
    @GetMapping("getbalance/{accountnumber}")
    public String getBalance(@PathVariable("accountnumber") String accountNr) {
        //Selleks, et saada kätte balance peame kirjutama SQL lause:
        String sql = "SELECT balance FROM account WHERE account_number =:dbAccNo"; //dbAccNo ehk defineerime muutuja, info, mida tahame sisse anda
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr); //dbAccNo defineerime muutuja
        Double balance = jdbcTemplate.queryForObject(sql, paramMap, Double.class); //Double.class on tagastustüüp
        return "The balance is: " + balance;
    }


    //URL: http://localhost:8080/deposit/{accountnumber}/{depositamount}
    @PutMapping("deposit/{accountnumber}/{depositamount}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("depositamount") Double amount) {
        if (amount > 0) {
            //String sql = "UPDATE account SET balance=:dbAmount WHERE account_number =:dbAccNo";
            //Map<String, Object> paramMap = new HashMap<>();

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
            //String sql = "UPDATE account SET balance=:dbAmount WHERE account_number =:dbAccNo";
            //Map<String, Object> paramMap = new HashMap<>();

            Double balance = accountBalanceMap.get(accountNr);
            //Double newBalance = balance - amount;
            if (balance >= 0) {
                balance = balance - amount;
                accountBalanceMap.put(accountNr, balance);
                return "The new balance is: " + balance; //accountBalanceMap.get(accountNr);
            } else {
                return "Invalid request";
            }
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/transfer/{accountnumber}/{amount}
    @PutMapping("transfer/{accountnumber}/{amount}")
    public String transfer(@PathVariable("accountnumber") String accountNr, @PathVariable("amount") Double amount) {

        if (amount > 0) {
            //String sql = "UPDATE account SET balance=:dbAmount WHERE account_number =:dbAccNo";
            //Map<String, Object> paramMap = new HashMap<>();

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
}
