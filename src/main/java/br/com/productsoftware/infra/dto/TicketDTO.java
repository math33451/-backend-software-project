package br.com.productsoftware.infra.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TicketDTO {

	private Long id;
	private String nomeSolicitante;
	private Long documentoSolicitante;
	private String emailSolicitante;
	private String telefoneSolicitante;
	private String numeroSerieBalanca;
	private Integer qtdBalanca;
	private Date dtEmissaoTicket;
	private boolean visualizado = false;
	private boolean atendido = false;
	private String descricao;
}
