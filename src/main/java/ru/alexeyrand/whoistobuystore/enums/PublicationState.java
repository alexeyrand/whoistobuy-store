package ru.alexeyrand.whoistobuystore.enums;

import ru.alexeyrand.whoistobuybase.fsm.StateWithAction;

import java.util.List;

/**
 * Состояние, описывающее жизненный цикл публикации
 * 1. Черновик — Публикация создана автором, но пока не готова к показу другим пользователям.
 * 2. На проверке — Публикация отправлена на модерацию администрацией магазина или автоматически ожидает проверки системой.
 * 3. Опубликовано — Проверка пройдена успешно, товар доступен для просмотра и покупки пользователями.
 * 4. Заблокировано/Отказано — Публикация не прошла проверку, запрещена к показу из-за нарушений правил площадки (например, нарушение авторских прав, недостоверная информация).
 * 5. Продано — Товар был куплен покупателем, статус отображается для информирования пользователей о доступности товара.
 * 6. Бронирование/Резервирование — Пользователь временно зарезервировал товар перед покупкой, исключив возможность приобретения другими клиентами на определенный срок.
 * 7. Архивное состояние — Товары с истекшим сроком годности или снятием с продажи остаются доступными для ознакомления в архиве сайта.
 * 8. Удалено автором — Автор самостоятельно решил убрать публикацию из каталога, сохраняя историю действий в административной панели.
 */
public enum PublicationState implements StateWithAction<PublicationAction> {

    IDLE(),
    DRAFT(List.of(PublicationAction.CREATE, PublicationAction.DELETE)),
    REVIEW(List.of(PublicationAction.REJECT, PublicationAction.PUBLISH, PublicationAction.DELETE)),
    REJECTED(List.of(PublicationAction.EDIT, PublicationAction.DELETE)),
    PUBLISHED(List.of(PublicationAction.RESERVE, PublicationAction.PAY, PublicationAction.ARCHIVE, PublicationAction.DELETE)),
    RESERVED(List.of(PublicationAction.PAY, PublicationAction.DELETE)),
    ARCHIVED(List.of(PublicationAction.DELETE)),
    AWAITING_PAYMENT(List.of(PublicationAction.CONFIRM, PublicationAction.DELETE)),
    AWAITING_CONFIRMATION(List.of(PublicationAction.SEND, PublicationAction.EXCHANGE, PublicationAction.DELETE)),
    AWAITING_EXCHANGE(List.of(PublicationAction.COMPLETION, PublicationAction.CANCEL, PublicationAction.DELETE)),
    AWAITING_DELIVERY(List.of(PublicationAction.COMPLETION, PublicationAction.CANCEL, PublicationAction.DELETE)),
    CANCELED(List.of(PublicationAction.PUBLISH, PublicationAction.DELETE)),
    SOLD(List.of(PublicationAction.DELETE)),
    DELETED(List.of());

    private List<PublicationAction> publicationActionList;

    PublicationState() {

    }

    PublicationState(List<PublicationAction> publicationActionList) {
        this.publicationActionList = publicationActionList;
    }

    @Override
    public List<PublicationAction> getActionList() {
        return publicationActionList;
    }

    @Override
    public void setActionList(List<PublicationAction> actionList) {

    }
}
