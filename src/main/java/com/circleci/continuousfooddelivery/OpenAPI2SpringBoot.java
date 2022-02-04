package com.circleci.continuousfooddelivery;

import com.circleci.continuousfooddelivery.jpa.ImageJpa;
import com.circleci.continuousfooddelivery.jpa.MenuItemJpa;
import com.circleci.continuousfooddelivery.repositories.CartRepo;
import com.circleci.continuousfooddelivery.repositories.ImageRepo;
import com.circleci.continuousfooddelivery.repositories.MenuRepo;
import com.fasterxml.jackson.databind.Module;
import org.modelmapper.ModelMapper;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OpenAPI2SpringBoot implements CommandLineRunner {

    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0) {
            switch (arg0[0]) {
                case "exitcode":
                    throw new ExitException();
                case "configure":
                    configure();
            }
        }
        configure();
    }

    @Autowired
    ResourceLoader resourceLoader;

    private void configure() throws IOException {
        if (menuRepo.count() == 0) {
            String[] images = new String[]{"water.jpg", "wrap.jpg", "stew.jpg", "soup.jpg", "salad.jpg", "pizza.jpg"};

            for (String image : images) {
                ClassPathResource resource = new ClassPathResource("images/" + image);

                imageRepo.save(new ImageJpa("image/jpg", resource.getInputStream().readAllBytes()));
            }

            menuRepo.saveAll(List.of(
                    new MenuItemJpa("Water", "Fresh from the tap", 1.99f, 1),
                    new MenuItemJpa("Chicken Wrap", "Chicken Wrap - Sandwich", 14.99f, 2),
                    new MenuItemJpa("Stew", "A slow cooked stew", 12.99f, 3),
                    new MenuItemJpa("Tomato Soup", "It looks good in the menu picture", 4.99f, 4),
                    new MenuItemJpa("Salad", "A green salad", 4.99f, 5),
                    new MenuItemJpa("Pizza", "A single slice of pizza", 2.99f, 6)
            ));
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(OpenAPI2SpringBoot.class).run(args);
    }

    static class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer webConfigurer() {
        return new WebMvcConfigurer() {
            /*@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("Content-Type");
            }*/

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/3.14.2/");
            }
        };
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
