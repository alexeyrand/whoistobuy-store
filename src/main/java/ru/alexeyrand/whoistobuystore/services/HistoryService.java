package ru.alexeyrand.whoistobuystore.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexeyrand.whoistobuybase.fsm.ActionWithState;
import ru.alexeyrand.whoistobuybase.fsm.StateWithAction;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuybase.services.Historical;
import ru.alexeyrand.whoistobuystore.entities.History;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.repositories.HistoryRepository;

@Service
@RequiredArgsConstructor
public class HistoryService extends BaseService<History> implements Historical<PublicationState, PublicationAction> {
    private final HistoryRepository historyRepository;

    @Override
    public void createHistory(PublicationState beforeState, PublicationState afterState, PublicationAction action) {
        History history = new History();
        history.setBeforeState(beforeState);
        history.setAfterState(afterState);
        history.setAction(action);
        this.save(history);
    }

    @Override
    public BaseRepository<History> getRepository() {
        return historyRepository;
    }
}
