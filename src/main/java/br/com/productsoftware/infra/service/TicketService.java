package br.com.productsoftware.infra.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.productsoftware.infra.TicketMapper;
import br.com.productsoftware.infra.domain.Ticket;
import br.com.productsoftware.infra.dto.TicketDTO;
import br.com.productsoftware.infra.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private TicketMapper mapper;

	public List<Ticket> buscarTodos() {
		return ticketRepository.findAll();
	}

	public void salvar(TicketDTO ticketDTO) {
		Ticket ticket = mapper.toDomain(ticketDTO);
		ticket.setDtEmissaoTicket(new Date());
		ticketRepository.save(ticket);
	}

	public List<Ticket> buscarTicketByDoc(Long documento) {
		return ticketRepository.findByDocumentoSolicitante(documento);
	}

	public void deletarTicket(Long id) {
		Ticket ticket = ticketRepository.findById(id).get();
		if(ticket != null) {
			ticketRepository.deleteById(id);
		}
	}

	public List<Ticket> consultarTicket(Long documento) {
		return ticketRepository.findByDocumentoSolicitante(documento).stream().filter(a -> 
		a.isVisualizado() == false).collect(Collectors.toList());
		
		
	}
	
}
