package ru.alexeyrand.whoistobuystore.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;
import ru.alexeyrand.whoistobuybase.fsm.Stateful;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;

import java.util.Date;

/**
 * Сущность, характеризующая публикацию в магазине
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PUBLICATION")
public class Publication extends BaseEntity implements Stateful<PublicationState> {

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "PUBLISH_STATUS")
    @Enumerated(EnumType.STRING)
    private PublicationState publicationState = PublicationState.DRAFT;

    @Column(name = "SOLD")
    private Boolean sold;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "SOLD_AT")
    private Date soldAt;

    @Column(name = "DELETED_AT")
    private Date deletedAt;

    @Override
    public void setState(PublicationState state) {
        this.publicationState = state;
    }

    @Override
    public PublicationState getState() {
        return publicationState;
    }
}
