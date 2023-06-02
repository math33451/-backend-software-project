package br.com.productsoftware.infra.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ClienteDTO {

	private Long id;
	private String nome;
	private Long documento;
	private String email;
	private String telefone;
	
	private List<String> balancas;
}
