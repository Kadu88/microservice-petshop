package com.ceobarros.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.ceobarros.produto.*")
public class ProdutoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}
}
