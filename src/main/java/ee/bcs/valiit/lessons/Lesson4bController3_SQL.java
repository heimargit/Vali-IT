package ee.bcs.valiit.lessons;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4bController3_SQL {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    @Autowired // ehk Inversion of Control - vastutab, et objekte luua ja neid hallata; loome ühenduse andmebaasiga
    private NamedParameterJdbcTemplate jdbcTemplate; //klass, mida kasutame. @Autowired inistsialiseerib selle.


    //URL: http://localhost:8080/createaccount3/EE003344680/300
    @PostMapping("createaccount3/{accountnumber}/{balance}")
    public void createAccount(@PathVariable("accountnumber") String accountNr, @PathVariable("balance") Double balance) {

        //Loon uue konto INSERT meetodiga:
        String sql = "INSERT INTO account (account_number, balance) VALUES(:dbAccNo, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbAmount", balance);
        jdbcTemplate.update(sql, paramMap); //kahe muutuja kasutamine tähendab, et see meetod ei tagasta meile midagi

        //accountBalanceMap.put(accountNr, balance);
    }

    //URL: http://localhost:8080/getbalance3/EE003344654
    @GetMapping("getbalance3/{accountnumber}")
    public String getBalance(@PathVariable("accountnumber") String accountNr) {

        //Selleks, et saada kätte balance kirjutan SQL lause:
        String sql = "SELECT balance FROM account WHERE account_number =:dbAccNo"; //dbAccNo ehk defineerime muutuja, info, mida tahame sisse anda
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr); //dbAccNo defineerime muutuja
        Double balance = jdbcTemplate.queryForObject(sql, paramMap, Double.class); //Double.class on tagastustüüp (= Double balance)!
        return "The balance is: " + balance;
    }


    //URL: http://localhost:8080/deposit3/EE123456790/1000
    @PutMapping("deposit3/{accountnumber}/{depositamount}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("depositamount") Double amount) {

        //Valin vastava konto, et saada kätte selle konto balance:
        String sqlBalance = "SELECT balance FROM account WHERE account_number =:dbAccNo";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbAccNo", accountNr);
        Double currentBalance = jdbcTemplate.queryForObject(sqlBalance, paramMap1, Double.class);

        if (amount > 0) {

            //Lisan kontole summa:
            String sqlAddAmount = "UPDATE account SET balance =:dbBalance WHERE account_number =:dbAccNo";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("dbAccNo", accountNr);
            Double newBalance = currentBalance + amount;
            paramMap2.put("dbBalance", newBalance);
            jdbcTemplate.update(sqlAddAmount, paramMap2);


            // Double currentBalance = accountBalanceMap.get(accountNr);
            //Double newBalance = currentBalance + amount;
            // accountBalanceMap.put(accountNr, newBalance);
            //return "The new balance is: " + accountBalanceMap.get(accountNr);

            return "The new balance is: " + newBalance;

        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/withdraw3/EE123456790/500
    @PutMapping("withdraw3/{accountnumber}/{withdrawamount}")
    public String withdrawMoney(@PathVariable("accountnumber") String accountNr, @PathVariable("withdrawamount") Double amount) {

        //Valin vastava konto, et saada kätte selle konto balance:
        String sqlBalance = "SELECT balance FROM account WHERE account_number =:dbAccNo";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbAccNo", accountNr);
        Double currentBalance = jdbcTemplate.queryForObject(sqlBalance, paramMap1, Double.class);

        if (amount > 0) {
            //Double balance = accountBalanceMap.get(accountNr);
            //Double newBalance = balance - amount;

            if (currentBalance >= 0) {

                //Võtan kontolt välja summa:
                String sqlNewBalance = "UPDATE account SET balance =:dbBalance WHERE account_number=:dbAccNo";
                Map<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("dbAccNo", accountNr);
                Double newBalance = currentBalance - amount;
                paramMap2.put("dbBalance", newBalance);
                jdbcTemplate.update(sqlNewBalance, paramMap2);

                //balance = balance - amount;
                //accountBalanceMap.put(accountNr, balance);
                return "The new balance is: " + newBalance; //accountBalanceMap.get(accountNr);
            } else {
                return "Invalid request";
            }
        } else {
            return "Invalid request";
        }
    }

    //URL: http://localhost:8080/transfer3/EE123456790/EE003344680/200
    @PutMapping("transfer3/{fromaccountnumber}/{toaccountnumber}/{amount}")
    public String transfer(@PathVariable("fromaccountnumber") String fromAccountNr, @PathVariable("toaccountnumber") String toAccountNr, @PathVariable("amount") Double amount) {

        //Valin vastava konto, et saada kätte FROM konto balance:
        String sqlFromBalance = "SELECT balance FROM account WHERE account_number =:dbFromAccNo";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbFromAccNo", fromAccountNr);
        Double currentFromBalance = jdbcTemplate.queryForObject(sqlFromBalance, paramMap1, Double.class);

        //Valin vastava konto, et saada kätte TO konto balance:
        String sqlToBalance = "SELECT balance FROM account WHERE account_number =:dbToAccNo";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("dbToAccNo", toAccountNr);
        Double currentToBalance = jdbcTemplate.queryForObject(sqlToBalance, paramMap2, Double.class);

        if (amount > 0) {
            //Double balance = accountBalanceMap.get(accountNr);

            if (currentFromBalance < amount) {
                return "Not enough money on your account";
            } else {

                //Kannan kontolt üle summa:
                String sqlNewFromBalance = "UPDATE account SET balance =:dbFromBalance WHERE account_number=:dbFromAccNo";
                Map<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("dbFromAccNo", fromAccountNr);
                Double newFromBalance = currentFromBalance - amount;
                paramMap3.put("dbFromBalance", newFromBalance);
                jdbcTemplate.update(sqlNewFromBalance, paramMap3);

                //Summa lisamine teisele kontole:
                String sqlNewToBalance = "UPDATE account SET balance =:dbToBalance WHERE account_number=:dbToAccNo";
                Map<String, Object> paramMap4 = new HashMap<>();
                paramMap4.put("dbToAccNo", toAccountNr);
                Double newToBalance = currentToBalance + amount;
                paramMap4.put("dbToBalance", newToBalance);
                jdbcTemplate.update(sqlNewToBalance, paramMap4);

                return "New balance is: " + newFromBalance;

                //balance = balance - amount;
                //accountBalanceMap.put(accountNr, balance);
                //return "New balance is: " + balance;
            }
        } else {
            return "Invalid request";
        }
    }
}
