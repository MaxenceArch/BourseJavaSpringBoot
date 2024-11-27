package licence.devoir3.services;

import licence.devoir3.entities.Action;
import licence.devoir3.repositories.ActionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActionService {
    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    public Action findById(Integer id) {
        return actionRepository.findById(id).orElse(null);
    }

    public List<Action> findActionsNotOwnedByTrader(Integer traderId) {
        return actionRepository.findActionsNotOwnedByTrader(traderId);
    }
}