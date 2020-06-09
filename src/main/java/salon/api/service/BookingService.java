package salon.api.service;

import io.jsonwebtoken.lang.Assert;
import org.springframework.stereotype.Service;
import salon.api.dto.BookedTimes;
import salon.api.model.Bookings;
import salon.api.model.OperationResult;
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

    public OperationResult cancelBooking(int bookingId) {
        try {
            bookingRepository.cancelBooking(bookingId);
            return new OperationResult(true, "CANCELLED", bookingId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new OperationResult(false, message, null);
        }
    }

}
