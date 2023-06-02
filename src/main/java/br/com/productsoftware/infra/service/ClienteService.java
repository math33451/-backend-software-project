package br.com.productsoftware.infra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.productsoftware.infra.domain.Cliente;
import br.com.productsoftware.infra.dto.ClienteDTO;
import br.com.productsoftware.infra.dto.TicketDTO;
import br.com.productsoftware.infra.mapper.ClienteMapper;
import br.com.productsoftware.infra.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	public void criarCliente(TicketDTO ticketDTO) {
		Cliente cliente = clienteMapper.ticketToCliente(ticketDTO);
		@SuppressWarnings("unlikely-arg-type")
		Optional<String> optional = cliente.getBalancas().stream().filter(c-> ticketDTO.equals(c)).findAny();
		if(optional.isEmpty()) {
			cliente.getBalancas().add(ticketDTO.getNumeroSerieBalanca());
		}
		clienteRepository.save(cliente);
	}

	public List<ClienteDTO> buscarTodos() {
		List<Cliente> lista = clienteRepository.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<ClienteDTO>();
		if(!lista.isEmpty()) {
			for(Cliente c : lista) {
				ClienteDTO dto = clienteMapper.toDTO(c);
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	public Cliente buscarClienteById(Long id) {
		return clienteRepository.findById(id).get();
	}
	
	public Cliente buscarClienteByDoc(Long documento) {
		return clienteRepository.findByDocumento(documento);
	}

	public void deletarCliente(Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		if(cliente != null) {
			clienteRepository.deleteById(id);
		}
		
	}
}
