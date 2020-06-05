package salon.api.controller;


import org.springframework.web.bind.annotation.*;
import salon.api.model.Bookings;
import salon.api.model.DisplayAvailableOffer;
import salon.api.model.Schedule;
import salon.api.repository.ScheduleRepository;
import salon.api.service.ScheduleService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleRepository scheduleRepository, ScheduleService scheduleService) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/all")
    public List<DisplayAvailableOffer> getDisplayOffers() {
        return scheduleRepository.displayAvailableOffers();
    }

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.getAllSchedules();
    }

    @GetMapping("/bookingWeek/{id}")
    public List<Bookings> getBookingWeek(@PathVariable("id") int hairdresserId) {
        return scheduleRepository.getHairdresserWeekSchedule(hairdresserId);
    }

}
