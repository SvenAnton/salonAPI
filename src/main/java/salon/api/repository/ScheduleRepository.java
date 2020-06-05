package salon.api.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import salon.api.model.Bookings;
import salon.api.model.DisplayAvailableOffer;
import salon.api.model.Schedule;

import java.util.List;

@Repository
public class ScheduleRepository {


    private final String initialAvailableOffersSqlString = "" +
            "select u.id, u.name, u.description, GROUP_CONCAT(distinct service.service_type separator ', ') as services\n" +
            "from schedule as sc\n" +
            "join services_in_schedule as sc_services\n" +
            "join user_service_list as user_services\n" +
            "join service as service\n" +
            "join user as u\n" +
            "where \n" +
            "\tsc.id = sc_services.schedule and\n" +
            "    sc_services.services = user_services.id and\n" +
            "    user_services.service = service.id and\n" +
            "    sc.schedule_manager = u.id\n" +
            "group by u.name;";

    private final String getHairdresserWeekScheduleSqlString = "" +
            "select * \n" +
            "from schedule\n" +
            "where schedule_manager=? and \n" +
            "\tstart_at >= CURDATE()\n" +
            "    AND start_at < CURDATE() + INTERVAL 7 DAY;";



    private final JdbcTemplate jdbcTemplate;
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DisplayAvailableOffer> displayAvailableOffers() {
        return jdbcTemplate.query(initialAvailableOffersSqlString,
                (row, number) -> new DisplayAvailableOffer(
                        row.getInt("id"),
                        row.getString("name"),
                        row.getString("description"),
                        row.getString("services")
                ));
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

    public List<Bookings> getHairdresserWeekSchedule(int hairdresserId) {
        return jdbcTemplate.query(getHairdresserWeekScheduleSqlString,
                new Object[]{hairdresserId},
                (row, number) -> new Bookings(
                        row.getInt("id"),
                        row.getString("schedule_type"),
                        row.getInt("schedule_manager"),
                        row.getInt("room_in_schedule"),
                        row.getString("start_at"),
                        row.getString("end_at")
        ));
    }





}
