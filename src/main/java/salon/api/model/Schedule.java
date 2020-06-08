package salon.api.model;

public class Schedule {

    private int id;
    private String schedule_type;
    private int schedule_manager;
    private int room_in_schedule;
    private String start_at;
    private String end_at;

    public Schedule(int id, String schedule_type, int schedule_manager,
                    int room_in_schedule, String start_at, String end_at) {
        this.id = id;
        this.schedule_type = schedule_type;
        this.schedule_manager = schedule_manager;
        this.room_in_schedule = room_in_schedule;
        this.start_at = start_at;
        this.end_at = end_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchedule_type() {
        return schedule_type;
    }

    public void setSchedule_type(String schedule_type) {
        this.schedule_type = schedule_type;
    }

    public int getSchedule_manager() {
        return schedule_manager;
    }

    public void setSchedule_manager(int schedule_manager) {
        this.schedule_manager = schedule_manager;
    }

    public int getRoom_in_schedule() {
        return room_in_schedule;
    }

    public void setRoom_in_schedule(int room_in_schedule) {
        this.room_in_schedule = room_in_schedule;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }
}
