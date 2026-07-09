package dev.ocaina.desafioitau.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Desafio Itaú + JAVA10X")
                        .description("Desafio Itaú + JAVA10X")
                        .version("1.0.0"));
    }
}
