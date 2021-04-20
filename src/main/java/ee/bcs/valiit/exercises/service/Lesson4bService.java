package ee.bcs.valiit.exercises.service;


import ee.bcs.valiit.exercises.repository.Lesson4bRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;



@Service
public class Lesson4bService {

    @Autowired
    private Lesson4bRepository bankAccountRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    public void createAccount(String accountNr, Double balance) {
        bankAccountRepository.createAccount(accountNr, balance);
    }

    public Double getBalance(String accountNr) {
        return bankAccountRepository.getBalance(accountNr);
    }

    public String deposit(String accountNr, Double amount) {
        if (amount > 0) {
            Double balance = bankAccountRepository.getBalance(accountNr);
            Double newBalance = balance + amount;
            bankAccountRepository.updateBalance(accountNr, newBalance);
            return "New balance is: "+ newBalance;
        } else {
            return "Invalid request";
        }
    }

    public String withdrawMoney(String accountNr, Double amount) {
        if (amount > 0) {
            Double currentBalance = bankAccountRepository.getBalance(accountNr);
            if (currentBalance >= 0) {
                Double newBalance = currentBalance - amount;
                bankAccountRepository.updateBalance(accountNr, newBalance);
                return "New balance is: "+ newBalance;
            } else {
                return "Invalid request";
            }
        } else {
            return "Invalid request";
        }
    }

    public String transfer(String fromAccountNr, String toAccountNr, Double amount) {
        Double currentFromBalance = bankAccountRepository.getBalance(fromAccountNr);
        Double currentToBalance = bankAccountRepository.getBalance(toAccountNr);
        if (amount > 0) {
            if (currentFromBalance < amount) {
                return "Not enough money on your account";
            } else {
                Double newFromBalance = currentFromBalance - amount;
                Double newToBalance = currentToBalance + amount;
                bankAccountRepository.transfer(fromAccountNr, toAccountNr, amount);
                return "Transaction was successful.";
            }
        } else {
            return "Invalid request";
        }


    }
}