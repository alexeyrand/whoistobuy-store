package ru.alexeyrand.whoistobuystore.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuystore.entities.History;
import ru.alexeyrand.whoistobuystore.repositories.HistoryRepository;

@Service
@RequiredArgsConstructor
public class HistoryService extends BaseService<History> {
    private final HistoryRepository historyRepository;

    @Override
    public BaseRepository<History> getRepository() {
        return historyRepository;
    }
}
