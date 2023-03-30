package br.com.productsoftware.mapper;

import org.springframework.stereotype.Component;

import br.com.productsoftware.domain.Cliente;
import br.com.productsoftware.dto.ClienteDTO;

@Component
public class ClienteMapper {

	public Cliente dtoParaDomain(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setDocumento(dto.getDocumento());
		cliente.setIdade(dto.getIdade());
		return cliente;
	}
	
	public ClienteDTO domainParaDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setDocumento(cliente.getDocumento());
		clienteDTO.setIdade(cliente.getIdade());
		return clienteDTO;
	}
}
