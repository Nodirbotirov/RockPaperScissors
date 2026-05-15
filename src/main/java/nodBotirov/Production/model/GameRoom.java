package nodBotirov.Production.model;

import java.util.HashMap;
import java.util.Map;

public class GameRoom {

    private String roomId;
    private String player1;
    private String player2;

    // player -> move
    private Map<String, String> moves = new HashMap<>();

    public GameRoom(String roomId, String player1, String player2) {
        this.roomId = roomId;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getRoomId() {
        return roomId;
    }
    public String getPlayer1() {
        return player1;
    }
    public String getPlayer2() {
        return player2;
    }
    public Map<String, String> getMoves() {
        return moves;
    }
}
