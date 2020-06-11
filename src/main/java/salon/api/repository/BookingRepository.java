package salon.api.repository;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import salon.api.model.Bookings;
import salon.api.model.CustomerBookingInfo;

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
            "insert into service_booking(customer, schedule, start_at, end_at, service) " +
            "values(?, (select id from schedule where schedule_manager = ? and date(start_at) = date(?)), ?, ?, ?)";

    private final String getCustomerBookings = "" +
            "            select b.id, b.start_at as start_at, b.end_at as end_at, l.city as city, l.street as street, " +
            "            l.building as building, service.name as service_name, usl.price as price " +
            "            from service_booking as b " +
            "            join schedule as sc " +
            "            join workplace as wp " +
            "            join location as l " +
            "            join services_in_schedule as sc_service " +
            "            join user_service_list as usl " +
            "            join service as service " +
            "            where " +
            "            b.customer = ? and " +
            "                b.schedule = sc.id and " +
            "                sc.room_in_schedule = wp.id and " +
            "                wp.location = l.id and " +
            "                sc_service.id = b.service and " +
            "                usl.id = sc_service.services and " +
            "                service.id = usl.service and " +
            "                cancelled = 0";

    private final String cancelBookingSqlString = "update service_booking set cancelled = 1 where id = ?";



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

    public boolean addBooking(Bookings booking) {
        try {
            jdbcTemplate.update(addBookingSqlString,
                    booking.getCustomer(), booking.getHairdresser(), booking.getStart_at(),
                    booking.getStart_at(), booking.getEnd_at(), booking.getService());
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CustomerBookingInfo> getCustomerBookings(int customerId) {
        return jdbcTemplate.query(getCustomerBookings,
                new Object[]{customerId},
                (row, number) -> new CustomerBookingInfo(
                        row.getInt("id"),
                        row.getString("start_at"),
                        row.getString("end_at"),
                        row.getString("city"),
                        row.getString("street"),
                        row.getString("building"),
                        row.getString("service_name"),
                        row.getInt("price")
                ));
    }


    public void cancelBooking(int bookingId) {
        jdbcTemplate.update(cancelBookingSqlString, bookingId);
    }




}
