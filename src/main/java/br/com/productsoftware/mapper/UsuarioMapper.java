package br.com.productsoftware.mapper;

import org.springframework.stereotype.Component;

import br.com.productsoftware.domain.Usuario;
import br.com.productsoftware.dto.UsuarioDTO;

@Component
public class UsuarioMapper {

	public Usuario dtoParaDomain(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		return usuario;
	}
	
	public UsuarioDTO domainParaDto(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setSenha(usuario.getSenha());
		return dto;
	}
}
