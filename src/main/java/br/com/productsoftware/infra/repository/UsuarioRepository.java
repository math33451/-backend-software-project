package br.com.productsoftware.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productsoftware.infra.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	void deleteByEmail(String email);
	
	Usuario findByEmail(String email);
}
