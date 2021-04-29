package ee.bcs.valiit.exercises.controller;


import ee.bcs.valiit.exercises.service.AccountTransactions;
import ee.bcs.valiit.exercises.service.Lesson4bService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("api") //lisab urli localhosti järele api/ ning võimaldab kustutada @Crossorigin
@RestController
public class Lesson4bController4SQLForServRepo {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    @Autowired
    private Lesson4bService bankAccountService;


    //URL: http://localhost:8080/createaccount4/{accountnumber}/{name}
//    @CrossOrigin
    @PostMapping("/createaccount4/{accountnumber}/{name}")
    public void createAccount(@PathVariable("accountnumber") String accountNr, @PathVariable("name") String ownerName) {
        bankAccountService.createAccount(accountNr, ownerName);
    }

    //URL: http://localhost:8080/getbalance4/EE0011111
//    @CrossOrigin
    @GetMapping("/getbalance4/{accountnumber}")
    public Double getBalance(@PathVariable("accountnumber") String accountNr) {
        return bankAccountService.getBalance(accountNr);
    }

    //URL: http://localhost:8080/deposit4/EE0011111/1000
//    @CrossOrigin
    @PutMapping("/deposit4/{accountnumber}/{depositamount}")
    public String deposit(@PathVariable("accountnumber") String accountNr, @PathVariable("depositamount") Double amount) {
        return bankAccountService.deposit(accountNr, amount);
    }

    //URL: http://localhost:8080/api/withdraw4/EE0011111/1000
//    @CrossOrigin
    @PutMapping("/withdraw4/{accountnumber}/{withdrawamount}")
    public String withdrawMoney(@PathVariable("accountnumber") String accountNr, @PathVariable("withdrawamount") Double amount) {
        return bankAccountService.withdrawMoney(accountNr, amount);
    }

    //URL: http://localhost:8080/api/transfer4/EE0011111/EE003344680/200
//    @CrossOrigin
    @PutMapping("/transfer4/{fromaccountnumber}/{toaccountnumber}/{amount}")
    public String transfer(@PathVariable("fromaccountnumber") String fromAccountNr, @PathVariable("toaccountnumber") String toAccountNr, @PathVariable("amount") Double amount) {
        return bankAccountService.transfer(fromAccountNr, toAccountNr, amount);
    }

    //URL: http://localhost:8080/api/deleteaccount4/EE0011112/Margit Loo
//    @CrossOrigin
    @DeleteMapping("/deleteaccount4/{accountnumber}/{name}")
    public String deleteAccount(@PathVariable("accountnumber") String accountNr, @PathVariable("name") String ownerName) {
        return bankAccountService.deleteAccount(accountNr, ownerName);
    }

    //URL: http://localhost:8080/api/getallaccounts
//    @CrossOrigin
    @GetMapping("/getallaccounts")
    public List<AccountTransactions> getAllAccounts(){
        return bankAccountService.getAllAccounts();
    }

}
