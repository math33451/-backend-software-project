package br.com.productsoftware.infra.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		domain.setBalancas(new ArrayList<>());
		
		return domain;
	}
	
	public TicketDTO toDTO(Ticket d) {
		TicketDTO dto = new TicketDTO();
		dto.setId(d.getId());
		dto.setNomeSolicitante(d.getNomeSolicitante());
		dto.setDocumentoSolicitante(d.getDocumentoSolicitante());
		dto.setEmailSolicitante(d.getEmailSolicitante());
		dto.setTelefoneSolicitante(d.getTelefoneSolicitante());
		dto.setNumeroSerieBalanca(d.getNumeroSerieBalanca());
		dto.setQtdBalanca(d.getQtdBalanca());
		dto.setDtEmissaoTicket(formataData(d.getDtEmissaoTicket()));
		dto.setDescricao(d.getDescricao());
		dto.setVisualizado(d.isVisualizado());
		dto.setAtendido(d.isAtendido());
		
		if(d.isAtendido()) {
			dto.setStatus("Encerrado");
		}else if(d.isVisualizado()) {
			dto.setStatus("Visualizado");;
		}else {
			dto.setStatus("Enviado");
		}
		
		return dto;
	}
	
	public String formataData(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = formatador.format(data);
		return dataFormatada;
	}
}
