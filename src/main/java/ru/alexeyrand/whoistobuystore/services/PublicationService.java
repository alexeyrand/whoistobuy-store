package ru.alexeyrand.whoistobuystore.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexeyrand.whoistobuybase.entities.User;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuybase.rest.WitbHttpClient;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuybase.services.UserService;
import ru.alexeyrand.whoistobuystore.entities.History;
import ru.alexeyrand.whoistobuystore.entities.Item;
import ru.alexeyrand.whoistobuystore.entities.Publication;
import ru.alexeyrand.whoistobuystore.enums.HistoryType;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;
import ru.alexeyrand.whoistobuystore.repositories.PublicationRepository;

/**
 * Сервис для работы с публикациями
 */
@Service
@RequiredArgsConstructor
public class PublicationService extends BaseService<Publication> {

    @PostConstruct
    private void createUser() {
        User user = new User();
        user.setChatId(658756678L);
        user.setTelephone("+79150187848");
        user.setUsername("Chichilipa");
        user.setAge(12);
        userService.save(user);
    }

    private final PublicationRepository publicationRepository;
    private final UserService userService;
    private final ItemService itemService;
    private final HistoryService historyService;
    private final WitbHttpClient witbHttpClient;

    /**
     * Создание публикации с товаром. Публикация приобретает статус "На проверке/REVIEW".
     */
    @Transactional
    public Publication addPublication(Item itemDto, String username) {
        User user = userService.findUserByUsername(username);
        Item item = itemService.save(itemDto);
        Publication publication = new Publication();
        publication.setUserId(user.getId());
        publication.setItemId(item.getId());
        publication.setPublicationState(PublicationState.REVIEW);
        witbHttpClient.sendMessage("http://whoistobuy-telegram:8085/api/v1/telegram-notification/");
        this.save(publication);
        return publication;
    }

    /**
     * Покупка товара через публикацию пользователем. Публикация приобретает статус "Продано/SOLD_OUT".
     */
    public Publication buyItemByPublicationId(Long id) {
        Publication publication = this.findById(id);
        publication.setPublicationState(PublicationState.SOLD_OUT);
        return publication;
    }

    /**
     * Отказ в публикации товара администратором. Публикация приобретает статус "Отказано/REJECTED".
     */
    public Publication rejectPublication(Long id) {
        Publication publication = this.findById(id);
        publication.setPublicationState(PublicationState.REJECTED);
        return publication;
    }

    /**
     * Архивирование публикации с товаром. Публикация приобретает статус "Архивировано/ARCHIVE".
     */
    public Publication archivePublication(Long id) {
        Publication publication = this.findById(id);
        publication.setPublicationState(PublicationState.ARCHIVED);
        return publication;
    }

    @Override
    public Publication beforeDelete(Publication entity) {
        historyService.save(History.builder()
                .HistoryType(HistoryType.DELETED)
                .Description("Удален")
                .publicationId(entity.getId())
                .build());
        return entity;
    }

    @Override
    public BaseRepository<Publication> getRepository() {
        return publicationRepository;
    }
}
