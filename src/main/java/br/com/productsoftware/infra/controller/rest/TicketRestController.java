package br.com.productsoftware.infra.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsoftware.infra.domain.Ticket;
import br.com.productsoftware.infra.service.TicketService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/rest/ticket")
public class TicketRestController {

	private TicketService ticketService;

	@GetMapping()
	public List<Ticket> buscarTodosClientes(){
		return ticketService.buscarTodos();
	}
}
