package nodBotirov.Production.service;

import nodBotirov.Production.model.GameRoom;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchmakingService {

    private Queue<String> queue = new LinkedList<>();
    private Map<String, GameRoom> rooms = new HashMap<>();

    public synchronized GameRoom join(String playerId, String player) {

        if (queue.isEmpty()) {
            queue.add(playerId);
            return null; //hali kutadi
        } else {
            String opponent = queue.poll();

            String roomId = UUID.randomUUID().toString();

            GameRoom gameRoom = new GameRoom(roomId, opponent, playerId);
            rooms.put(roomId, gameRoom);

            return gameRoom;
        }
    }
    public GameRoom getRoom(String roomId) {
        return rooms.get(roomId);
    }
}
