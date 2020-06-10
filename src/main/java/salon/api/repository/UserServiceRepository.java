package salon.api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceRepository {

    private final String getServicesSqlString = "SELECT name FROM service";


    private final JdbcTemplate jdbcTemplate;

    public UserServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<String> getDefaultServices() {
        return jdbcTemplate.query(getServicesSqlString,
                (row, number) -> new String(row.getString("name")));
    }


}
