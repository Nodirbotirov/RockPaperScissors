//package nodBotirov.Production.config;
//
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class GameWebSocketHandler extends TextWebSocketHandler {
//
//    private WebSocketSession player1;
//    private WebSocketSession player2;
//
//    private Map<WebSocketSession, String> moves = new HashMap<>();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        if (player1 == null){
//            player1 = session;
//            session.sendMessage(new TextMessage("You are Player 1"));
//        } else {
//            player2 = session;
//            session.sendMessage(new TextMessage("You are Player 2"));
//        }
//    }
//
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//
//        moves.put(session, message.getPayload());
//
//        if (moves.size() == 2) {
//            String move1 = moves.get(player1);
//            String move2 = moves.get(player2);
//
//            String result = decide(move1, move2);
//
//            player1.sendMessage(new TextMessage("Opponent: " + move2 + " | " + result));
//            player1.sendMessage(new TextMessage("Opponent: " + move1 + " | " + result));
//
//            moves.clear();
//        }
//    }
//
//    private String decide(String p1, String p2) {
//
//        if (p1.equals(p2)) return "Draw!";
//
//        if (p1.equals("Rock") && p2.equals("Scissors")) return "Player 1 Wins!";
//        if (p1.equals("Paper") && p2.equals("Rock")) return "Player 1 Wins!";
//        if (p1.equals("Scissors") && p2.equals("Paper")) return "Player 1 Wins!";
//
//        return "Player 2 Wins!\n";
//    }
//
//}
