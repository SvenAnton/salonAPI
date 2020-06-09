package salon.api.model;

public class CustomerBookingInfo {

    private int id;
    private String start_at;
    private String end_at;
    private String city;
    private String street;
    private String building;
    private String service_name;
    private int price;

    public CustomerBookingInfo(int id, String start_at, String end_at, String city,
                               String street, String building, String service_name, int price) {
        this.id = id;
        this.start_at = start_at;
        this.end_at = end_at;
        this.city = city;
        this.street = street;
        this.building = building;
        this.service_name = service_name;
        this.price = price;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
