package br.com.productsoftware.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsoftware.domain.Usuario;
import br.com.productsoftware.security.dto.UserDTO;
import br.com.productsoftware.security.service.TokenService;
import br.com.productsoftware.security.service.UsuarioService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsuarioController {
	
	@Autowired
    private TokenService tokenService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
		Usuario usuario = usuarioService.validarUsuario(userDTO);
		if(usuario != null) {
			String token = tokenService.gerarToken(usuario);
			return ResponseEntity.ok().body(token);
		}
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/criarUsuario")
	public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario){
		usuarioService.salvar(usuario);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/list")
	public List<Usuario> listar(){
		return usuarioService.buscarTodos();
	}
	
	@GetMapping("/logout")
	public boolean logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		return true;
	}
}
