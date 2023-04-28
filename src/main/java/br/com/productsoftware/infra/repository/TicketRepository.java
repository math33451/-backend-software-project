package br.com.productsoftware.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productsoftware.infra.domain.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	List<Ticket> findByDocumentoSolicitante(Long documento);
}
