package br.com.productsoftware.infra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsoftware.infra.domain.Cliente;
import br.com.productsoftware.infra.dto.ClienteDTO;
import br.com.productsoftware.infra.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public List<ClienteDTO> buscarTodosTickets(){
		return clienteService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Cliente buscarClienteById(@PathVariable Long id) {
		return clienteService.buscarClienteById(id);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> deletarCliente(@PathVariable Long id){
		clienteService.deletarCliente(id);
		return ResponseEntity.ok().build();
	}
}
