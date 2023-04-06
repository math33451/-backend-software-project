package br.com.productsoftware.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsoftware.domain.Cliente;
import br.com.productsoftware.dto.ClienteDTO;
import br.com.productsoftware.exception.ClienteException;
import br.com.productsoftware.mapper.ClienteMapper;
import br.com.productsoftware.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
	
	private ClienteMapper clienteMapper;

	@GetMapping()
	public List<Cliente> buscarTodosClientes(){
		return clienteService.buscarTodos();
	}
	
	@GetMapping("/{documento}")
	public Cliente buscarCliente(@PathVariable String documento) {
		return clienteService.buscarClienteByDoc(documento);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> criarCliente(@RequestBody ClienteDTO clienteDTO) throws Exception {
		try {
			clienteService.salvar(clienteMapper.dtoParaDomain(clienteDTO));
			return ResponseEntity.ok().build();
		} catch (ClienteException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@DeleteMapping("/apagar/{documento}")
	public ResponseEntity<?> deletarCliente(@PathVariable String documento){
		clienteService.deletarCliente(documento);
		return ResponseEntity.ok().build();
	}
}
