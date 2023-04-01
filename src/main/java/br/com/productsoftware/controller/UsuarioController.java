package br.com.productsoftware.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsoftware.domain.Usuario;
import br.com.productsoftware.dto.UsuarioDTO;
import br.com.productsoftware.mapper.UsuarioMapper;
import br.com.productsoftware.service.UsuarioService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UsuarioController {

private UsuarioService usuarioService;
	
	private UsuarioMapper usuarioMapper;
	
	@GetMapping()
	public List<Usuario> buscarTodosUsuarios(){
		return usuarioService.buscarTodos();
	}
	
	@GetMapping("/{email}")
	public Usuario buscarUsuario(@PathVariable String email) {
		return usuarioService.buscarPorEmail(email);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
		usuarioService.salvar(usuarioMapper.dtoParaDomain(usuarioDTO));
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/logar")
	public Boolean logar(@RequestBody UsuarioDTO usuarioDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return usuarioService.logar(usuarioMapper.dtoParaDomain(usuarioDTO));
	}
	
	@DeleteMapping("/apagar/{email}")
	public ResponseEntity<?> deletarUsuario(@PathVariable String email){
		usuarioService.deletarUsuario(email);
		return ResponseEntity.ok().build();
	}
}
