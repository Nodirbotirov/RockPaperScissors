package nodBotirov.Production.dto;

public class UserResponseDTO {

    private Long id;
    private String username;
    private int wins;

    public UserResponseDTO(Long id, String username, int wins) {
        this.id = id;
        this.username = username;
        this.wins = wins;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getWins() {
        return wins;
    }
}
