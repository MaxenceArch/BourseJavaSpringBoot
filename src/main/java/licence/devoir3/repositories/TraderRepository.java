package licence.devoir3.repositories;

import licence.devoir3.entities.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, Integer> {
}