package nodBotirov.Production.controller;

import nodBotirov.Production.dto.MoveMessage;
import nodBotirov.Production.model.GameRoom;
import nodBotirov.Production.service.GameService;
import nodBotirov.Production.service.MatchService;
import nodBotirov.Production.service.MatchmakingService;
import nodBotirov.Production.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private final MatchmakingService matchmakingService;
    private final SimpMessagingTemplate messagingTemplate;
    private final GameService gameService;
    private final MatchService matchService;
    private final UserService userService;

    public GameController(
            MatchmakingService matchmakingService,
            SimpMessagingTemplate messagingTemplate,
            GameService gameService,
            MatchService matchService,
            UserService userService
    ) {

        this.matchmakingService = matchmakingService;
        this.messagingTemplate = messagingTemplate;
        this.gameService = gameService;
        this.matchService = matchService;
        this.userService = userService;
    }

    @MessageMapping("/join")
    public void joinRoom(MoveMessage message) {

        matchmakingService.join(
                message.getRoomId(),
                message.getPlayer()
        );

        messagingTemplate.convertAndSend(
                "/topic/room/" + message.getRoomId(),
                message.getPlayer() + " joined room!"
        );
    }

    @MessageMapping("/move")
    public void move(MoveMessage move) {

        GameRoom room =
                matchmakingService.getRoom(
                        move.getRoomId()
                );

        String result =
                gameService.processMove(
                        room,
                        move.getPlayer(),
                        move.getMove()
                );

        if (result == null) {
            return;
        }

        messagingTemplate.convertAndSend(
                "/topic/room/" + move.getRoomId(),
                result
        );

        String winner =
                gameService.extractWinner(result);

        if (winner != null) {

            userService.addWinByUsername(winner);

            matchService.saveMatch(
                    room.getPlayer1(),
                    room.getPlayer2(),
                    winner
            );
        }

        room.getMoves().clear();
    }
}