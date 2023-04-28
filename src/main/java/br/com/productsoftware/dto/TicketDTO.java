package br.com.productsoftware.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TicketDTO {

	private String nomeSolicitante;
	private Long documentoSolicitante;
	private String numeroSerieBalança;
	private Date dtEmissaoTicket;
	private boolean visualizado;
	private boolean atendido;
	private String descricao;
}
