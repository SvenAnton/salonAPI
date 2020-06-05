package salon.api.model;

public class DisplayAvailableOffer {

    private int id;
    private String name;
    private String description;
    private String services;

    public DisplayAvailableOffer(int id, String name, String description, String services) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
