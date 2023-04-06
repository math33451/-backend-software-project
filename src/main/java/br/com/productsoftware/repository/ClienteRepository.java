package br.com.productsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productsoftware.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByDocumento(String documento);
	
	void deleteByDocumento(String documento);

	Cliente findByEmail(String email);
}
