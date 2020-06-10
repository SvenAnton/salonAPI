package salon.api.dto;

public class JwtResponseDto {
    private final int id;
    private final String email;
    private final String token;

    public JwtResponseDto(int id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return this.token;
    }

}
