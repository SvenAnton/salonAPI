package salon.api.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salon.api.model.*;
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


    @PostMapping("/add")
    public ResponseEntity<OperationResult> addCompany(@RequestBody Schedule schedule) {
        OperationResult result = scheduleService.addSchedule(schedule);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/add/services")
    public ResponseEntity<OperationResult> addServicesToSchedule(@RequestBody ServicesInSchedule services) {
        OperationResult result = scheduleService.addServicesToSchedule(services);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }




}
