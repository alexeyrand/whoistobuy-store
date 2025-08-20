package ru.alexeyrand.whoistobuystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuystore.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long>, BaseRepository<Publication> {
}
