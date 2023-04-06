package br.com.productsoftware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.productsoftware.domain.Cliente;
import br.com.productsoftware.exception.ClienteException;
import br.com.productsoftware.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public void salvar(Cliente cliente) throws ClienteException {
		try {
			Cliente clienteExistente = this.buscarClienteByDoc(cliente.getDocumento());
			if(clienteExistente != null) {
				throw new ClienteException("Cliente já registrado com este documento.");
			}
			clienteExistente = this.buscarClienteByEmail(cliente.getEmail());
			if(clienteExistente != null) {
				throw new ClienteException("Cliente já registrado com este email.");
			}
			clienteRepository.save(cliente);
		} catch (ClienteException e) {
			throw new ClienteException(e.getMessage());
		}
	}

	public Cliente buscarClienteByDoc(String documento) {
		return clienteRepository.findByDocumento(documento);
	}
	
	public Cliente buscarClienteByEmail(String email) {
		return clienteRepository.findByEmail(email);
	}

	public void deletarCliente(String documento) {
		clienteRepository.deleteByDocumento(documento);
	}
	
}
