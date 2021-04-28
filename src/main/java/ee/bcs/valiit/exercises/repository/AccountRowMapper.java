package ee.bcs.valiit.exercises.repository;

import ee.bcs.valiit.exercises.service.AccountTransactions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<AccountTransactions> {

    @Override
    public AccountTransactions mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountTransactions result = new AccountTransactions();
        result.setBalance(resultSet.getDouble("balance"));
        result.setAccountNumber(resultSet.getString("account_number"));
        return result;
    }
}
