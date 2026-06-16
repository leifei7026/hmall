package com.hmall.service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI hmallOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("hmall 商城 API")
                        .description("Spring Cloud 微服务商城系统接口文档")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("hmall")
                                .email("admin@hmall.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("hmall 接口文档")
                        .url("http://localhost:8080/doc.html"));
    }
}
