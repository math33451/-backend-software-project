package br.com.productsoftware.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ClienteDTO {

	String nome;
	String documento;
	Integer idade;
	String email;
}
