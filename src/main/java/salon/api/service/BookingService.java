package salon.api.service;

import org.springframework.stereotype.Service;
import salon.api.dto.BookedTimes;
import salon.api.model.Bookings;
import salon.api.repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    public List<BookedTimes> getBookedTimesInWeek (int hairdresserId) {
        List<BookedTimes> bookedTimes = new ArrayList<>();
        bookingRepository.getBookingWeek(hairdresserId).forEach(booking -> {
            BookedTimes bookedTime = new BookedTimes(
                    booking.getStart_at(), booking.getEnd_at());
            bookedTimes.add(bookedTime);
        });
        return bookedTimes;
    }
}
