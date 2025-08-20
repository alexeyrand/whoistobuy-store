package ru.alexeyrand.whoistobuystore.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;
import ru.alexeyrand.whoistobuystore.enums.HistoryType;

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

    @Column(name = "HISTORY_TYPE")
    @Enumerated(EnumType.STRING)
    private ru.alexeyrand.whoistobuystore.enums.HistoryType HistoryType;

}
