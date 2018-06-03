package server.electronics;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import server.electronics.product.dto.ProductDto;

@SpringBootApplication
public class ElectronicsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElectronicsApplication.class, args);
    }

}


