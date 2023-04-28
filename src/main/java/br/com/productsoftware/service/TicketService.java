package br.com.productsoftware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.productsoftware.domain.Ticket;
import br.com.productsoftware.dto.TicketDTO;
import br.com.productsoftware.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public List<Ticket> buscarTodos() {
		return ticketRepository.findAll();
	}

	public void salvar(TicketDTO ticketDTO) {
		Ticket ticket = new Ticket();
		ticketRepository.save(ticket);
	}

	public List<Ticket> buscarTicketByDoc(String documento) {
		return ticketRepository.findByDocumento(documento);
	}

	public void deletarTicket(Long id) {
		Ticket ticket = ticketRepository.findById(id).get();
		if(ticket != null) {
			ticketRepository.deleteById(id);
		}
	}
	
}
