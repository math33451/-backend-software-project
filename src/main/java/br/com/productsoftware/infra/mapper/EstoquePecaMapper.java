package br.com.productsoftware.infra.mapper;

import org.springframework.stereotype.Component;

import br.com.productsoftware.infra.domain.EstoquePeca;
import br.com.productsoftware.infra.dto.EstoquePecaDTO;

@Component
public class EstoquePecaMapper {

	public EstoquePeca toDomain(EstoquePecaDTO dto) {
		EstoquePeca domain = new EstoquePeca();
		domain.setNome(dto.getNome());
		domain.setQuantidade(dto.getQuantidade());
		domain.setValor(dto.getValor());
		
		return domain;
	}
	
	public EstoquePecaDTO domainToDTO(EstoquePeca domain) {
		EstoquePecaDTO dto = new EstoquePecaDTO();
		dto.setId(domain.getId());
		dto.setNome(domain.getNome());
		dto.setQuantidade(domain.getQuantidade());
		dto.setValor(domain.getValor());
		
		return dto;
	}
}
