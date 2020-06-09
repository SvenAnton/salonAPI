package salon.api.dto;

public class JwtResponseDto {
    private final int id;
    private final String username;
    private final String token;

    public JwtResponseDto(int id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return this.token;
    }

}
