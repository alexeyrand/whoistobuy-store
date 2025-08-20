package ru.alexeyrand.whoistobuystore.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Version;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;
import ru.alexeyrand.whoistobuystore.enums.Category;
import ru.alexeyrand.whoistobuystore.enums.Sex;

/**
 * Сущность, характеризующая объект публикации
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ITEMS")
public class Item extends BaseEntity {

    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "SEX")
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "IMAGE")
    private String image;
    @Version
    public Integer version;
}
