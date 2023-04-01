package br.com.productsoftware.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;
}
