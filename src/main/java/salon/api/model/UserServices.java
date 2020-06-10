package salon.api.model;

public class UserServices {

    private String email;
    private String service;
    private int price;
    private int duration;

    public UserServices(String email, String service, int price, int duration) {
        this.email = email;
        this.service = service;
        this.price = price;
        this.duration = duration;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
