package nodBotirov.Production.service;

import nodBotirov.Production.model.Room;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchmakingService {

    private Queue<String> queue = new LinkedList<>();
    private Map<String, Room> rooms = new HashMap<>();

    public synchronized Room join(String playerId) {

        if (queue.isEmpty()) {
            queue.add(playerId);
            return null; //hali kutadi
        } else {
            String opponent = queue.poll();

            String roomId = UUID.randomUUID().toString();

            Room room = new Room(roomId, opponent, playerId);
            rooms.put(roomId, room);

            return room;
        }
    }
    public Room getRoom(String roomId) {
        return rooms.get(roomId);
    }
}
