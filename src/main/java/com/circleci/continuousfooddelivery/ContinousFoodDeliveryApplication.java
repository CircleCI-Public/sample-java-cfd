package com.circleci.continuousfooddelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContinousFoodDeliveryApplication {

    ContinousFoodDeliveryApplication() {
        ApiClient client = new ApiClient();
        CartApi cart = new CartApi(client);
    }

    public static void main(String[] args) {
        SpringApplication.run(ContinousFoodDeliveryApplication.class, args);
    }

}
