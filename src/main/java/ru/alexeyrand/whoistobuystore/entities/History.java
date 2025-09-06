package ru.alexeyrand.whoistobuystore.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;
import ru.alexeyrand.whoistobuystore.enums.PublicationAction;
import ru.alexeyrand.whoistobuystore.enums.PublicationState;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HISTORY")
public class History extends BaseEntity {

    @Column(name = "PUBLICATION_ID")
    private Long publicationId;

    @Column(name = "DESCRIPTION")
    private String Description;

    @Column(name = "BEFORE_STATE")
    @Enumerated(EnumType.STRING)
    private PublicationState beforeState;

    @Column(name = "AFTER_STATE_TYPE")
    @Enumerated(EnumType.STRING)
    private PublicationState afterState;

    @Column(name = "ACTION")
    @Enumerated(EnumType.STRING)
    private PublicationAction action;

}
