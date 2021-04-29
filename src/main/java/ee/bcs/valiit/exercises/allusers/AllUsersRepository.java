package ee.bcs.valiit.exercises.allusers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AllUsersRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public String loginUsername(AllUsersData allUsersData) {
        String sql = "SELECT password FROM all_accounts WHERE username=:dbUsername";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbUsername", allUsersData.getUsername());
        String password = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return password;
    }


    public void createUsername(AllUsersData allUsersData) {
        String sql = "INSERT INTO all_accounts (username, password) VALUES(:dbUsername, :dbPassword)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbUsername", allUsersData.getUsername());
        paramMap.put("dbBalance", allUsersData.getPassword());
        jdbcTemplate.update(sql, paramMap);
    }

}
