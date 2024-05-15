package br.com.missio.apipagamento.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

    return new OpenAPI().info(new Info()
            .title("API Pagamento")
            .description("API para pagamento de boletos")
            .contact(new Contact()
                    .name("Rafael Missio")
                    .email("rtmissio@gmail.com"))
            .version("1.0"));
                            

    }

}
