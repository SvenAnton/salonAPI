package salon.api.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import salon.api.model.Schedule;

import java.util.List;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Schedule> getAllSchedules() {
        return jdbcTemplate.query("select * from schedule",
                (row, number) -> new Schedule(
                        row.getInt("id"),
                        row.getString("schedule_type"),
                        row.getString("schedule_manager"),
                        row.getInt("room_in_schedule"),
                        row.getString("start_at"),
                        row.getString("end_at")
                ));


    }


}
