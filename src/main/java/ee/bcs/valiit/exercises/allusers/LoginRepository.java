package ee.bcs.valiit.exercises.allusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginRepository {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate2;


    public String getPasswordByUsername(String username) {
        String sql = "SELECT password FROM all_accounts WHERE username =:dbUsername";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbUsername", username);
        return jdbcTemplate2.queryForObject(sql, paramMap, String.class);
    }


    public void createUser(String username, String password) {
        String sql = "INSERT INTO all_accounts(username, password) VALUES(:dbUsername, :dbPassword)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbUsername", username);
        paramMap.put("dbPassword", password);
        jdbcTemplate2.update(sql, paramMap);

    }

}
