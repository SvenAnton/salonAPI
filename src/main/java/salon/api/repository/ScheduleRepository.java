package salon.api.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import salon.api.model.Hairdresser;
import salon.api.model.Schedule;
import salon.api.model.Services;

import java.util.List;

@Repository
public class ScheduleRepository {


    private final String initialAvailableOffersSqlString = "" +
            "select u.id, u.first_name as first_name, u.description as description, " +
            "GROUP_CONCAT(distinct service.service_type separator ', ') as services, u.profile_picture as picture " +
            "from schedule as sc " +
            "join services_in_schedule as sc_services " +
            "join user_service_list as user_services " +
            "join service as service " +
            "join user as u " +
            "where " +
            "sc.id = sc_services.schedule and " +
            "    sc_services.services = user_services.id and " +
            "    user_services.service = service.id and " +
            "    sc.schedule_manager = u.id " +
            "group by first_name;";

    private final String getHairdresserWeekScheduleSqlString = "" +
            "select * \n" +
            "from schedule\n" +
            "where schedule_manager=? and \n" +
            "\tstart_at >= CURDATE()\n" +
            "    AND start_at < CURDATE() + INTERVAL 7 DAY;";

    private final String getHairdresserServicesByIdSqlString = "" +
            "select distinct usl.id as id, service.name as name, usl.duration as duration, usl.price as price\n" +
            "from services_in_schedule as sc_services\n" +
            "join user_service_list as usl\n" +
            "join service as service\n" +
            "join schedule as sc\n" +
            "where \n" +
            "\tsc.schedule_manager = ? and\n" +
            "    sc.id = sc_services.schedule and\n" +
            "\tsc_services.services = usl.id and\n" +
            "    usl.service = service.id";



    private final JdbcTemplate jdbcTemplate;
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Hairdresser> displayAvailableHairdressers() {
        return jdbcTemplate.query(initialAvailableOffersSqlString,
                (row, number) -> new Hairdresser(
                        row.getInt("id"),
                        row.getString("first_name"),
                        row.getString("description"),
                        row.getString("services"),
                        row.getString("picture")
                ));
    }

    public List<Schedule> getAllSchedules() {
        return jdbcTemplate.query("select * from schedule",
                (row, number) -> new Schedule(
                        row.getInt("id"),
                        row.getString("schedule_type"),
                        row.getInt("schedule_manager"),
                        row.getInt("room_in_schedule"),
                        row.getString("start_at"),
                        row.getString("end_at")
                ));
    }

    public List<Schedule> getHairdresserWeekSchedule(int hairdresserId) {
        return jdbcTemplate.query(getHairdresserWeekScheduleSqlString,
                new Object[]{hairdresserId},
                (row, number) -> new Schedule(
                        row.getInt("id"),
                        row.getString("schedule_type"),
                        row.getInt("schedule_manager"),
                        row.getInt("room_in_schedule"),
                        row.getString("start_at"),
                        row.getString("end_at")
        ));
    }


    public List<Services> getHairdresserServices(int hairdresserId) {
        return jdbcTemplate.query(getHairdresserServicesByIdSqlString,
                new Object[]{hairdresserId},
                (row, number) -> new Services(
                        row.getInt("id"),
                        row.getString("name"),
                        row.getInt("duration"),
                        row.getInt("price")
        ));
    }







}
