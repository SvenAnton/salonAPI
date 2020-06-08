package salon.api.controller;


import org.springframework.web.bind.annotation.*;
import salon.api.model.Bookings;
import salon.api.repository.BookingRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/week/{id}")
    public List<Bookings> getBookingWeek(@PathVariable("id") int hairdresserID) {
        return bookingRepository.getBookingWeek(hairdresserID);
    }

    @PostMapping("/add")
    public void addBooking(@RequestBody Bookings newBooking) {
        bookingRepository.addBooking(newBooking);
    }
}
