package salon.api.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import salon.api.dto.UserServiceListDto;
import salon.api.model.Schedule;

import java.util.List;

@Repository
public class UserServiceRepository {

    private final String getServicesSqlString = "SELECT name FROM service";
    private final String getUserServicesSqlString = "" +
            "select usl.id as usl_id, s.name as service_name " +
            "from user_service_list as usl " +
            "join service as s " +
            "join user as u " +
            "where u.email = ? and usl.user = u.id and usl.service = s.id " +
            "group by s.name";


    private final JdbcTemplate jdbcTemplate;

    public UserServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<String> getDefaultServices() {
        return jdbcTemplate.query(getServicesSqlString,
                (row, number) -> new String(row.getString("name")));
    }


    public List<UserServiceListDto> getUserServices(String userEmail) {
        return jdbcTemplate.query(getUserServicesSqlString,
                new Object[]{userEmail},
                (row, number) -> new UserServiceListDto(
                        row.getString("usl_id"),
                        row.getString("service_name")
                ));
    }



}
