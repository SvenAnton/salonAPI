package salon.api.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salon.api.dto.BookedTimes;
import salon.api.model.Bookings;
import salon.api.model.CustomerBookingInfo;
import salon.api.model.OperationResult;
import salon.api.repository.BookingRepository;
import salon.api.service.BookingService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    public BookingController(BookingRepository bookingRepository, BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    @GetMapping("/week/{id}")
    public List<BookedTimes> getBookingWeek(@PathVariable("id") int hairdresserId) {
        return bookingService.getBookedTimesInWeek(hairdresserId);
    }

    @PostMapping("/add")
    public void addBooking(@RequestBody Bookings newBooking) {
        bookingRepository.addBooking(newBooking);
    }

    @GetMapping("/customer/{id}")
    public List<CustomerBookingInfo> getCustomerBookings(@PathVariable("id") int customerId) {
        return bookingRepository.getCustomerBookings(customerId);
    }

    @PostMapping("/cancel/{bookingId}")
    public ResponseEntity<OperationResult> cancelBooking(@PathVariable("bookingId") int id) {
        OperationResult result = bookingService.cancelBooking(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

}
