package com.backend.libros;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LibrosApplication {
	private static Logger logger = LoggerFactory.getLogger(LibrosApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LibrosApplication.class, args);
		logger.info("Aplicacion de libreria is running now...");
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
