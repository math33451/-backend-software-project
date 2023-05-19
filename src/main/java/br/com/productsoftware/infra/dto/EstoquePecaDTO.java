package br.com.productsoftware.infra.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EstoquePecaDTO {

	private Long id;
	private String nome;
	private BigDecimal valor;
	private Integer quantidade;
}
