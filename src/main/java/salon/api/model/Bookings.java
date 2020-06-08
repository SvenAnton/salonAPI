package salon.api.model;

public class Bookings {

    private int id;
    private int customer;
    private int schedule;
    private String description;
    private String start_at;
    private String end_at;
    private int cancelled;
    private int service;
    private String hairdresser;

    public Bookings() {}

    public Bookings(int id, int customer, int schedule, String description, String start_at, String end_at,
                    int cancelled, int service) {
        this.id = id;
        this.customer = customer;
        this.schedule = schedule;
        this.description = description;
        this.start_at = start_at;
        this.end_at = end_at;
        this.cancelled = cancelled;
        this.service = service;
    }

    public Bookings(int customer, String start_at, String end_at, int service,
                    String hairdresser) {
        this.customer = customer;
        this.start_at = start_at;
        this.end_at = end_at;
        this.service = service;
        this.hairdresser = hairdresser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getHairdresser() {
        return hairdresser;
    }

    public void setHairdresser(String hairdresser) {
        this.hairdresser = hairdresser;
    }
}
