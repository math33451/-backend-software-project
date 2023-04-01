package br.com.productsoftware.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.productsoftware.domain.Usuario;
import br.com.productsoftware.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public Long salvar(Usuario usuario) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		usuario.setSenha(this.criptografaSenha(usuario.getSenha()));
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return usuarioSalvo.getId();
	}

	public void deletarUsuario(String email) {
		usuarioRepository.deleteByEmail(email);
		
	}

	public Boolean logar(Usuario usuarioDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		Usuario usuarioDomain = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		if(usuarioDomain != null) {
			if(this.comparaSenha(usuarioDTO, usuarioDomain)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	private String criptografaSenha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		
		StringBuilder hexString = new StringBuilder();
	    	for (byte b : messageDigest) {
	    		hexString.append(String.format("%02X", 0xFF & b));
	    	}
	       String senhahex = hexString.toString();
	       return senhahex;
	}
	
	private boolean comparaSenha(Usuario dto, Usuario domain) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String senhaDto = this.criptografaSenha(dto.getSenha());
		return domain.getSenha().equals(senhaDto) == true ? true : false;
	}

}
