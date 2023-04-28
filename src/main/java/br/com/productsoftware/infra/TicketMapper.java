package br.com.productsoftware.infra;

import org.springframework.stereotype.Component;

import br.com.productsoftware.infra.domain.Ticket;
import br.com.productsoftware.infra.dto.TicketDTO;

@Component
public class TicketMapper {

	public Ticket toDomain(TicketDTO dto) {
		Ticket domain = new Ticket();
		domain.setNomeSolicitante(dto.getNomeSolicitante());
		domain.setDocumentoSolicitante(dto.getDocumentoSolicitante());
		domain.setEmailSolicitante(dto.getEmailSolicitante());
		domain.setTelefoneSolicitante(dto.getTelefoneSolicitante());
		domain.setNumeroSerieBalanca(dto.getNumeroSerieBalanca());
		domain.setQtdBalanca(dto.getQtdBalanca());
		domain.setDescricao(dto.getDescricao());
		
		return domain;
	}
}
