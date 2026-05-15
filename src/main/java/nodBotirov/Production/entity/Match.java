package nodBotirov.Production.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String player1;

    private String player2;

    private String winner;

    public Match() {

    }

    public Match(String player1, String player2, String winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getWinner() {
        return winner;
    }
}
