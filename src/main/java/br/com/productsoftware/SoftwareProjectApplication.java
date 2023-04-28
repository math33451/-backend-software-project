package br.com.productsoftware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareProjectApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/ticket-api");
		SpringApplication.run(SoftwareProjectApplication.class, args);
	}

}
