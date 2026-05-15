package nodBotirov.Production.service;

import nodBotirov.Production.entity.Match;
import nodBotirov.Production.repository.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void saveMatch(
            String player1,
            String player2,
            String winner
    ) {

        Match match = new Match(
                player1,
                player2,
                winner
        );

        matchRepository.save(match);
    }
}
