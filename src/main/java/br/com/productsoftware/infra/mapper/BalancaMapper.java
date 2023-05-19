package br.com.productsoftware.infra.mapper;

import org.springframework.stereotype.Component;

import br.com.productsoftware.infra.domain.Balanca;
import br.com.productsoftware.infra.dto.BalancaDTO;

@Component
public class BalancaMapper {

	public Balanca toDomain(BalancaDTO dto) {
		Balanca domain = new Balanca();
		domain.setDocumentoProprietario(dto.getDocumentoProprietario());
		domain.setNumeroSerie(dto.getNumeroSerie());
		domain.setTickets(dto.getTickets());
		
		return domain;
	}
	
	public BalancaDTO domainToDTO(Balanca domain) {
		BalancaDTO dto = new BalancaDTO();
		dto.setId(domain.getId());
		dto.setDocumentoProprietario(domain.getDocumentoProprietario());
		dto.setNumeroSerie(domain.getNumeroSerie());
		dto.setTickets(domain.getTickets());
		
		return dto;
	}
}
