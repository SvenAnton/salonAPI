package salon.api.service;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import salon.api.model.OperationResult;
import salon.api.model.Schedule;
import salon.api.model.ServicesInSchedule;
import salon.api.repository.ScheduleRepository;

@Service
public class ScheduleService {



    private final ScheduleRepository scheduleRepository;
    private final JdbcTemplate jdbcTemplate;

    public ScheduleService(ScheduleRepository scheduleRepository, JdbcTemplate jdbcTemplate) {
        this.scheduleRepository = scheduleRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public OperationResult addSchedule(Schedule schedule) {
        try {
            int scheduleId = scheduleRepository.addSchedule(schedule);
            return new OperationResult(true, "OK", scheduleId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new OperationResult(false, message, null);
        }
    }

    public OperationResult addServicesToSchedule(ServicesInSchedule services) {
        try {
            scheduleRepository.addServicesToSchedule(services);
            return new OperationResult(true, "OK");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            String message = e.getMessage();
            return new OperationResult(false, message);
        }
    }






}
