package salon.api.model;

public class Bookings {

    private int id;
    private String schedule_type;
    private int hairdresser;
    private int room;
    private String start_at;
    private String end_at;

    public Bookings(int id, String schedule_type, int hairdresser, int room, String start_at, String end_at) {
        this.id = id;
        this.schedule_type = schedule_type;
        this.hairdresser = hairdresser;
        this.room = room;
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

    public int getHairdresser() {
        return hairdresser;
    }

    public void setHairdresser(int hairdresser) {
        this.hairdresser = hairdresser;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
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
