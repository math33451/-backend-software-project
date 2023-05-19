package br.com.productsoftware.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productsoftware.infra.domain.EstoquePeca;

@Repository
public interface EstoquePecaRepository extends JpaRepository<EstoquePeca, Long>{

}
