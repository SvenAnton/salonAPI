package salon.api.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import salon.api.model.Bookings;

import java.util.List;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    private final String getHaidresserBookingWeekSqlString = "" +
            "select b.*\n" +
            "from service_booking as b\n" +
            "join schedule as sc\n" +
            "where sc.schedule_manager = ? and\n" +
            "cancelled = 0 and \n" +
            "sc.id = b.schedule and\n" +
            "b.start_at >= CURDATE() and\n" +
            "b.start_at < CURDATE() + INTERVAL 7 DAY";

    private final String addBookingSqlString = "" +
            "insert into service_booking(customer, schedule, start_at, end_at, service)\n" +
            "values(?, (select id from schedule where schedule_manager = ? and date(start_at) = date(?)), ?, ?, ?)";



    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bookings> getBookingWeek(int hairdresserId) {
        return jdbcTemplate.query(getHaidresserBookingWeekSqlString,
                new Object[]{hairdresserId},
                (row, number) -> new Bookings(
                        row.getInt("id"),
                        row.getInt("customer"),
                        row.getInt("schedule"),
                        row.getString("description"),
                        row.getString("start_at"),
                        row.getString("end_at"),
                        row.getInt("cancelled"),
                        row.getInt("service")
                ));
    }

    public void addBooking(Bookings booking) {
        jdbcTemplate.update(addBookingSqlString,
                booking.getCustomer(), booking.getHairdresser(), booking.getStart_at(),
                booking.getStart_at(), booking.getEnd_at(), booking.getService());
    }



}
