package ru.alexeyrand.whoistobuystore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexeyrand.whoistobuybase.controllers.HealthRestController;

@RestController
@RequestMapping("api/v1/health-check/")
public class HealthShopRestController extends HealthRestController {
}
