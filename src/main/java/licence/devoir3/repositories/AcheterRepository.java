package licence.devoir3.repositories;

import licence.devoir3.entities.Acheter;
import licence.devoir3.entities.AcheterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AcheterRepository extends JpaRepository<Acheter, AcheterId> {
    List<Acheter> findByIdNumTrader(Integer traderId);

    @Query("SELECT a FROM Acheter a WHERE a.id.numTrader = ?1 AND a.id.numAction = ?2")
    Acheter findByTraderAndAction(Integer traderId, Integer actionId);
}