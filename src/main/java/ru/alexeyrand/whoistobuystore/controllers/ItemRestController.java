package ru.alexeyrand.whoistobuystore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.whoistobuybase.controllers.BaseRestController;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuystore.entities.Item;
import ru.alexeyrand.whoistobuystore.services.ItemService;

/**
 * Контроллер для работы с айтемами
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/items")
public class ItemRestController extends BaseRestController<Item> {

    private final ItemService itemService;

//    /**
//     * Метод для получения товаров пользователя
//     * @param username - имя пользователя
//     * @return
//     */
//    @GetMapping(value = "/my/{username}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<List<Item>> getItemsByUsername(@PathVariable String username) {
//        List<Item> items = itemService.getItemsByUsername(username);
//        return ResponseEntity.ok().body(items);
//    }

//    /**
//     * Создать новое объявление по имени пользователя
//     * @param username - имя пользователя
//     * @return
//     */
//    @PostMapping("/{username}")
//    public ResponseEntity<Item> addItemByUsername(@RequestBody Item item, @PathVariable String username) {
//        Item items = itemService.addItemsByUsername(item, username);
//        return ResponseEntity.ok().body(items);
//    }

    @Override
    public BaseService<Item> getService() {
        return itemService;
    }
}
