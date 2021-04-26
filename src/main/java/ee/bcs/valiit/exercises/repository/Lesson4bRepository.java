package ee.bcs.valiit.exercises.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Lesson4bRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void createAccount(String accountNr, String ownerName, Double balance) {
        String sql = "INSERT INTO account (account_number, owner_name, balance) VALUES(:dbAccNo, :dbName, :dbBalance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbBalance", balance);
        paramMap.put("dbName", ownerName);
        jdbcTemplate.update(sql, paramMap);
    }

    public Double getBalance(String accountNr) {
        String sql = "SELECT balance FROM account WHERE account_number =:dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Double.class);
    }


    public void updateBalance(String accountNr, Double amount) {
        String sqlAddAmount = "UPDATE account SET balance =:dbBalance WHERE account_number =:dbAccNo";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("dbAccNo", accountNr);
        paramMap2.put("dbBalance", amount);
        jdbcTemplate.update(sqlAddAmount, paramMap2);
        //return jdbcTemplate.queryForObject(sqlAddAmount, paramMap2, Double.class); //lisasin, et tagastada Double
    }

//    public void transfer(String fromAccountNr, String toAccountNr, Double amount) {
//                String sqlNewFromBalance = "UPDATE account SET balance =:dbNewFromBalance WHERE account_number=:dbFromAccNo";
//                Map<String, Object> paramMap3 = new HashMap<>();
//                paramMap3.put("dbFromAccNo", fromAccountNr);
//                paramMap3.put("dbNewFromBalance", amount);
//                jdbcTemplate.update(sqlNewFromBalance, paramMap3);
//
//                String sqlNewToBalance = "UPDATE account SET balance =:dbNewToBalance WHERE account_number=:dbToAccNo";
//                Map<String, Object> paramMap4 = new HashMap<>();
//                paramMap4.put("dbToAccNo", toAccountNr);
//                paramMap4.put("dbNewToBalance", amount);
//                jdbcTemplate.update(sqlNewToBalance, paramMap4);
//    }

    public void deleteAccount(String accountNr, String ownerName) {
        String sqlDelete = "DELETE FROM account WHERE account_number =:dbAccNo AND owner_name =:dbName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbName", ownerName);
        jdbcTemplate.update(sqlDelete, paramMap);
    }

}
