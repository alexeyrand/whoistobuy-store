package ru.alexeyrand.whoistobuystore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.whoistobuybase.controllers.BaseRestController;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuystore.entities.Item;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.services.PublicationService;

/**
 * Контроллер для работы с публикациями
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/publications")
public class PublicationRestController extends BaseRestController<Publication> {

    private final PublicationService publicationService;

    @PostMapping("/add/{username}")
    public ResponseEntity<Publication> addPublication(Item itemDto, @PathVariable String username) {
        Publication publication = publicationService.addPublication(itemDto, username);
        return ResponseEntity.ok().body(publication);
    }

    @GetMapping("/reject/{id}") //TODO
    public ResponseEntity<Publication> rejectPublication(@PathVariable Long id) {
        Publication publication = publicationService.buyItemByPublicationId(id);
        return ResponseEntity.ok().body(publication);
    }

    @GetMapping("/buy/{id}")
    public ResponseEntity<Publication> buyPublication(@PathVariable Long id) {
        Publication publication = publicationService.buyItemByPublicationId(id);
        return ResponseEntity.ok().body(publication);
    }

    @GetMapping("/archive/{id}")
    public ResponseEntity<Publication> archivePublication(@PathVariable Long id) {
        Publication publication = publicationService.archivePublication(id);
        return ResponseEntity.ok().body(publication);
    }

    @Override
    public BaseService<Publication> getService() {
        return publicationService;
    }
}
