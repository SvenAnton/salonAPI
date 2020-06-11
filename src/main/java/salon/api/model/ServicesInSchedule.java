package salon.api.model;

import java.util.List;

public class ServicesInSchedule {
    private int id;
    private int schedule_id;
    private List<Integer> services_id;

    public ServicesInSchedule() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public List<Integer> getServices_id() {
        return services_id;
    }

    public void setServices_id(List<Integer> services_id) {
        this.services_id = services_id;
    }
}
