package licence.devoir3.services;

import licence.devoir3.entities.Trader;
import licence.devoir3.repositories.TraderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TraderService {
    private final TraderRepository traderRepository;

    public TraderService(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public List<Trader> findAll() {
        return traderRepository.findAll();
    }

    public Trader findById(Integer id) {
        return traderRepository.findById(id).orElse(null);
    }
}