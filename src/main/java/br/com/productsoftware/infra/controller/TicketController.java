package br.com.productsoftware.infra.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsoftware.infra.domain.Ticket;
import br.com.productsoftware.infra.dto.TicketDTO;
import br.com.productsoftware.infra.service.TicketService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
	
	private TicketService ticketService;

	@GetMapping()
	public List<Ticket> buscarTodosTickets(){
		return ticketService.buscarTodos();
	}
	
	@GetMapping("/{documento}")
	public List<Ticket> buscarTicket(@PathVariable Long documento) {
		return ticketService.buscarTicketByDoc(documento);
	}
	
	@GetMapping("/pendentes")
	public Long buscarQuantidadeTicketsPendentes() {
		Long qtd = ticketService.buscarTodos().stream().filter(a -> a.isVisualizado() == false).collect(Collectors.toList()).stream().count();
		return qtd;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> criarTicket(@RequestBody TicketDTO ticketDTO){
		List<Ticket> ticketsPendentes =  ticketService.consultarTicket(ticketDTO.getDocumentoSolicitante());
		if(ticketsPendentes != null) {
			return ResponseEntity.ok("Ticket já enviado, aguarde o retorno da equipe.");
		}
		ticketService.salvar(ticketDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> deletarTicket(@PathVariable Long id){
		ticketService.deletarTicket(id);
		return ResponseEntity.ok().build();
	}
}
