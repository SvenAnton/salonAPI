package salon.api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import salon.api.model.User;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String addCustomerSqlString = "" +
            "insert into user(first_name, last_name, email, password, phone, user_type) " +
            "values(?, ?, ?, ?, ?, 'juuksur')";



    public User getUser(String email) {
        return jdbcTemplate.queryForObject("select id, first_name, last_name, email, password, phone " +
                        "from user where email = ?",
                new Object[]{email},
                (row, number) ->  new User(
                        row.getInt("id"),
                        row.getString("first_name"),
                        row.getString("last_name"),
                        row.getString("email"),
                        row.getString("password"),
                        row.getString("phone")
                ));
    }

    public boolean userExists(String username) {
        Integer count = jdbcTemplate.queryForObject(
                "select count(id) from user where email = ?",
                new Object[]{username},
                Integer.class
        );
        return count != null && count > 0;
    }

    public void addUser(User user) {
        jdbcTemplate.update(addCustomerSqlString,
                user.getFirst_name(), user.getLast_name(), user.getEmail(),
                user.getPassword(), user.getPhone());
    }

    public int getUserIdByEmail(String email) {
        return jdbcTemplate.queryForObject("select id from user where email = ?",
                new Object[]{email}, Integer.class);
    }

}