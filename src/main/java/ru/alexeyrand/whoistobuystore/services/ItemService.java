package ru.alexeyrand.whoistobuystore.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexeyrand.whoistobuybase.entities.User;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuybase.services.UserService;
import ru.alexeyrand.whoistobuystore.entities.Item;
import ru.alexeyrand.whoistobuystore.enums.Category;
import ru.alexeyrand.whoistobuystore.repositories.ItemRepository;

import java.util.Objects;
import java.util.stream.IntStream;


/**
 * Сервис для работы с айтемами
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ItemService extends BaseService<Item> {

    private final ItemRepository itemRepository;
    private final UserService userService;

//    @PostConstruct
//    public void fillDB() {
//        User user = new User();
//        user.setPassword("$2a$10$ocQMQiMHe0FfroNpfsnryeIjwv3UXE49sUoOGUnJrvKMSsdv7g0N.");
//        user.setUsername("qq");
//        userService.save(user);
//        IntStream.range(0, 3).boxed().forEach(i -> {
//            Item item = new Item();
//            item.setCategory(Category.PoloAndTShirts);
//            item.setTitle("Название");
//            item.setCode(Objects.toString(i*i));
//            item.setPrice(4000d);
//            item.setDescription("Это длинное описание товара. Тут может быть ввсе что угодно, но сейчас оставлю так.");
//            itemRepository.save(item);
//        });
//    }


//    public List<Item> getItemsByUsername(String username) {
//        User user = userService.findUserByUsername(username).orElseThrow(NoSuchElementException::new);
//        return itemRepository.findItemsByUserId(user.getId()).orElseThrow();
//    }

    //    public Item addItemsByUsername(Item item, String username) {
//        User user = userService.findUserByUsername(username).orElseThrow(NoSuchElementException::new);
//        item.setUserId(user.getId());
//        return this.save(item);
//    }

    @Override
    public Item beforeSave(Item entity) {
        return super.beforeSave(entity);
    }

    @Override
    public BaseRepository<Item> getRepository() {
        return itemRepository;
    }


}
