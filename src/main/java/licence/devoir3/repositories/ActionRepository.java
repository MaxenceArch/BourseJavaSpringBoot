package licence.devoir3.repositories;

import licence.devoir3.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    @Query("SELECT a FROM Action a WHERE a.id NOT IN (SELECT ac.id.numAction FROM Acheter ac WHERE ac.id.numTrader = ?1)")
    List<Action> findActionsNotOwnedByTrader(Integer traderId);
}