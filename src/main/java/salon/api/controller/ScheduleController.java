package salon.api.controller;


import org.springframework.web.bind.annotation.*;
import salon.api.model.Hairdresser;
import salon.api.model.Schedule;
import salon.api.model.Services;
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
    public List<Hairdresser> displayAvailableHairdressers() {
        return scheduleRepository.displayAvailableHairdressers();
    }



    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.getAllSchedules();
    }

    @GetMapping("/week/{id}")
    public List<Schedule> getScheduleWeek(@PathVariable("id") int hairdresserId) {
        return scheduleRepository.getHairdresserWeekSchedule(hairdresserId);
    }

    @GetMapping("/services/{id}")
    public List<Services> getHairdresserServices(@PathVariable("id") int hairdresserId) {
        return scheduleRepository.getHairdresserServices(hairdresserId);
    }



}
