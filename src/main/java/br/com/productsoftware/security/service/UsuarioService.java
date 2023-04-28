package br.com.productsoftware.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import br.com.productsoftware.infra.domain.Usuario;
import br.com.productsoftware.infra.repository.UsuarioRepository;
import br.com.productsoftware.security.dto.UserDTO;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarTodos() {
		List<Usuario> listUsuarios = usuarioRepository.findAll();
		listUsuarios.stream().forEach(usuario ->{
			usuario.setSenha(null);
			usuario.setSalt(null);
		});;
		return listUsuarios;
	}

	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public void salvar(Usuario usuario){
		
		String saltSenha = BCrypt.gensalt();
		usuario.setSenha(criptografaSenha(usuario.getSenha(), saltSenha));
		usuario.setSalt(saltSenha);
		usuarioRepository.save(usuario);
	}

	public void deletarUsuario(String email) {
		usuarioRepository.deleteByEmail(email);
	}
	
	private String criptografaSenha(String senha, String salt) {
		String senhaCrypt = BCrypt.hashpw(senha, salt);
		return senhaCrypt;
		
	}

	public Usuario validarUsuario(UserDTO userDTO) {
		Usuario usuario = buscarPorEmail(userDTO.getEmail());
		String senhaCryp = criptografaSenha(userDTO.getSenha(), usuario.getSalt());
		if(usuario.getSenha().equals(senhaCryp)) {
			return usuario;
		}
		return null;
		
	}

}
