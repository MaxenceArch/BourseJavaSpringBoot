package licence.devoir3.services;

import licence.devoir3.entities.Acheter;
import licence.devoir3.entities.AcheterId;
import licence.devoir3.repositories.AcheterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AcheterService {
    private final AcheterRepository acheterRepository;

    public AcheterService(AcheterRepository acheterRepository) {
        this.acheterRepository = acheterRepository;
    }

    public List<Acheter> findByTraderId(Integer traderId) {
        return acheterRepository.findByIdNumTrader(traderId);
    }

    public void save(Acheter acheter) {
        acheterRepository.save(acheter);
    }

    public void delete(AcheterId id) {
        acheterRepository.deleteById(id);
    }

    public Acheter findByTraderAndAction(Integer traderId, Integer actionId) {
        return acheterRepository.findByTraderAndAction(traderId, actionId);
    }

    public boolean vendreActions(Integer traderId, Integer actionId, Integer quantite) {
        Acheter achat = findByTraderAndAction(traderId, actionId);
        if (achat == null || achat.getQuantite() < quantite) {
            return false;
        }

        if (achat.getQuantite().equals(quantite)) {
            delete(achat.getId());
        } else {
            achat.setQuantite(achat.getQuantite() - quantite);
            save(achat);
        }
        return true;
    }

    public void acheterAction(Integer traderId, Integer actionId, Double montant, Integer quantite) {
        Acheter acheter = new Acheter();
        AcheterId id = new AcheterId();
        id.setNumTrader(traderId);
        id.setNumAction(actionId);
        acheter.setId(id);
        acheter.setMontantAchat(montant);
        acheter.setQuantite(quantite);
        save(acheter);
    }
}
