package br.com.productsoftware.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productsoftware.infra.domain.Balanca;

@Repository
public interface BalancaRepository extends JpaRepository<Balanca, Long>{

	List<Balanca> findByDocumentoProprietario(Long documento);
	
	Balanca findByNumeroSerie(String numeroSerie);
}
