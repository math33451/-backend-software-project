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

import br.com.productsoftware.domain.Ticket;
import br.com.productsoftware.dto.TicketDTO;
import br.com.productsoftware.service.TicketService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
	
	private TicketService ticketService;

	@GetMapping()
	public List<Ticket> buscarTodosClientes(){
		return ticketService.buscarTodos();
	}
	
	@GetMapping("/{documento}")
	public List<Ticket> buscarTicket(@PathVariable String documento) {
		return ticketService.buscarTicketByDoc(documento);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> criarTicket(@RequestBody TicketDTO ticketDTO) throws Exception {
		ticketService.salvar(ticketDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> deletarTicket(@PathVariable Long id){
		ticketService.deletarTicket(id);
		return ResponseEntity.ok().build();
	}
}
