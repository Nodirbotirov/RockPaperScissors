package nodBotirov.Production.service;

import nodBotirov.Production.model.GameRoom;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String processMove(
            GameRoom gameRoom,
            String player,
            String move
    ) {
        gameRoom.getMoves().put(player, move);

        if (gameRoom.getMoves().size() < 2) {
            return null;
        }

        String p1Move =
                gameRoom.getMoves()
                        .get(gameRoom.getPlayer1());

        String p2Move =
                gameRoom.getMoves()
                        .get(gameRoom.getPlayer2());

        return decideWinner(
                gameRoom.getPlayer1(),
                p1Move,
                gameRoom.getPlayer2(),
                p2Move

        );
    }

    public String decideWinner(
            String player1,
            String move1,
            String player2,
            String move2
    ) {

        if (move1.equals(move2)) {
            return "Draw!";
        }

        boolean player1Wins =
                (move1.equals("Rock")
                        && move2.equals("Scissors"))
                        ||
                (move1.equals("Paper")
                        && move2.equals("Rock"))
                        ||
                (move1.equals("Scissors")
                        && move2.equals("Paper"));

        if (player1Wins) {
            return player1 + " wins!";
        }

        return player2 + " wins!";
    }

    public String extractWinner(String result) {

        if (result.equals("Draw!")) {
            return null;
        }

        return result.replace(" wins!", "");
    }
}
