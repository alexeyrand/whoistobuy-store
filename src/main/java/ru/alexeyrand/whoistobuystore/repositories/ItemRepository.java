package ru.alexeyrand.whoistobuystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuystore.entities.Item;

/**
 * Репозиторий для работы с айтемами
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, BaseRepository<Item> {

    /**
     *
     */
//    public Optional<List<Item>> findItemsByUserId(Long userId);


}
