package ru.alexeyrand.whoistobuystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuystore.entities.History;

public interface HistoryRepository extends JpaRepository<History, Long>, BaseRepository<History> {
}
