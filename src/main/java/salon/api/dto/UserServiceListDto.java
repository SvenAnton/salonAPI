package salon.api.dto;

public class UserServiceListDto {

    private String user_service_list;
    private String service_name;

    public UserServiceListDto(String user_service_list, String service_name) {
        this.user_service_list = user_service_list;
        this.service_name = service_name;
    }

    public String getUser_service_list() {
        return user_service_list;
    }

    public void setUser_service_list(String user_service_list) {
        this.user_service_list = user_service_list;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}