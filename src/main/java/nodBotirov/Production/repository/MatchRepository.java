package nodBotirov.Production.repository;

import nodBotirov.Production.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository
        extends JpaRepository<Match, Long> {
}
