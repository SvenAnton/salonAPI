package salon.api.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import salon.api.model.OperationResult;
import salon.api.model.UserServices;
import salon.api.repository.UserServiceRepository;

@Service
public class UserServiceService {

    private final String addUserServiceSqlString = "" +
            "insert into user_service_list(user, service, price, duration) " +
            "values(" +
            "   (select id from user where email = ?), " +
            "   (select id from service where name = ?), " +
            "    ?, ?)";

    private final UserServiceRepository userServiceRepository;
    private final JdbcTemplate jdbcTemplate;

    public UserServiceService(UserServiceRepository userServiceRepository, JdbcTemplate jdbcTemplate) {
        this.userServiceRepository = userServiceRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public OperationResult addUserService(UserServices service) {
        try {
            jdbcTemplate.update(addUserServiceSqlString, service.getEmail(),
                    service.getService(), service.getPrice(), service.getDuration());
            return new OperationResult(true, "Service added");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new OperationResult(false, message);
        }
    }



}
