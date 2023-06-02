package br.com.productsoftware.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.productsoftware.infra.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByDocumento(Long documento);

}