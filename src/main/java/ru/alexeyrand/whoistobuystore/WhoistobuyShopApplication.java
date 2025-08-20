package ru.alexeyrand.whoistobuystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ru.alexeyrand.*")
public class WhoistobuyShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhoistobuyShopApplication.class, args);
	}

}
