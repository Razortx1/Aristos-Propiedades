package com.aristos_propiedades.aristos_propiedades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class AristosPropiedadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AristosPropiedadesApplication.class, args);
	}
	@Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }

}
