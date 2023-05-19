package br.com.productsoftware.infra.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.productsoftware.infra.domain.Ticket;
import lombok.Data;

@Data
@Component
public class BalancaDTO {

	private Long id;
	private String numeroSerie;
	private Long documentoProprietario;
	private List<Ticket> tickets;
}
