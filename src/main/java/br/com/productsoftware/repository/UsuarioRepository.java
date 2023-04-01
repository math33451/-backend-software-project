package br.com.productsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productsoftware.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	void deleteByEmail(String email);
	
	Usuario findByEmail(String email);
}
