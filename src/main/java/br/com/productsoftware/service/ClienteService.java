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
			Cliente clienteExistente = this.buscarCliente(cliente.getDocumento());
			if(clienteExistente != null) {
				throw new ClienteException("Cliente já registrado com este documento.");
			}
			clienteRepository.save(cliente);
		} catch (ClienteException e) {
			throw new ClienteException("Cliente já registrado com este documento.");
		}
	}

	public Cliente buscarCliente(String documento) {
		return clienteRepository.findByDocumento(documento);
	}

	public void deletarCliente(String documento) {
		clienteRepository.deleteByDocumento(documento);
	}
	
}
