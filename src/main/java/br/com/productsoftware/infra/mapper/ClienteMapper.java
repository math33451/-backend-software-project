package br.com.productsoftware.infra.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.productsoftware.infra.domain.Cliente;
import br.com.productsoftware.infra.dto.ClienteDTO;
import br.com.productsoftware.infra.dto.TicketDTO;

@Component
public class ClienteMapper {

	public Cliente ticketToCliente(TicketDTO dto) {
		Cliente cliente = new Cliente();
		List<String> balancas = new ArrayList<>();
		cliente.setNome(dto.getNomeSolicitante());
		cliente.setDocumento(dto.getDocumentoSolicitante());
		cliente.setEmail(dto.getEmailSolicitante());
		cliente.setTelefone(dto.getTelefoneSolicitante());
		cliente.setBalancas(balancas);		
		return cliente;
	}
	
	public ClienteDTO toDTO(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setDocumento(cliente.getDocumento());
		dto.setEmail(cliente.getEmail());
		dto.setTelefone(cliente.getTelefone());
		dto.setBalancas(cliente.getBalancas());
		return dto;
	}
	
//	public Cliente toDomain(ClienteDTO dto) {
//		Cliente domain = new Cliente();
//		dto.setNome(cliente.getNome());
//		dto.setDocumento(cliente.getDocumento());
//		dto.setEmail(cliente.getEmail());
//		dto.setTelefone(cliente.getTelefone());
//		dto.setBalancas(cliente.getBalancas());
//		return dto;
//	}
}
