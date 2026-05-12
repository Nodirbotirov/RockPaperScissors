package nodBotirov.Production.controller;

import nodBotirov.Production.dto.MoveMessage;
import nodBotirov.Production.model.Room;
import nodBotirov.Production.service.MatchmakingService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private final MatchmakingService service;
    private final SimpMessagingTemplate messagingTemplate;

    public GameController(MatchmakingService service,
                          SimpMessagingTemplate messagingTemplate) {
        this.service = service;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/join")
    public void join(String playerId) {

        Room room = service.join(playerId);

        if (room == null) {
            messagingTemplate.convertAndSend("/topic/match",
                    "Waiting for opponent...");

        } else {

            String roomTopic = "/topic/room/" + room.getRoomId();

            messagingTemplate.convertAndSend(roomTopic,
                    "Match: " + room.getPlayer1() + " vs " + room.getPlayer2());

            messagingTemplate.convertAndSend("/topic/match",
                    "Room created: " + room.getRoomId());
        }
    }

    @MessageMapping("/move")
    public void move(@Payload MoveMessage message) {

        Room room = service.getRoom(message.getRoomId());

        room.getMoves().put(
                message.getPlayer(),
                message.getMove()
        );

        if (room.getMoves().size() == 2) {

            String p1Move = room.getMoves().get(room.getPlayer1());
            String p2Move = room.getMoves().get(room.getPlayer2());

            String result = decide(
                    room.getPlayer1(),
                    p1Move,
                    room.getPlayer2(),
                    p2Move
            );

            messagingTemplate.convertAndSend(
                    "/topic/room/" + room.getRoomId(),
                    result
            );

            room.getMoves().clear();
        }
    }

    private String decide(String p1,
                          String m1,
                          String p2,
                          String m2) {
        if (m1.equals(m2)) {
            return "Draw!";
        }

        if (
                (m1.equals("Rock") && m2.equals("Scissors")) ||
                (m1.equals("Paper") && m2.equals("Rock")) ||
                (m1.equals("Scissors") && m2.equals("Paper"))
        ){
            return p1 + " wins!";
        }

        return p2 + " wins!";
    }


}
