package br.com.productsoftware.infra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsoftware.infra.domain.EstoquePeca;
import br.com.productsoftware.infra.dto.EstoquePecaDTO;
import br.com.productsoftware.infra.service.EstoquePecaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/estoque")
public class EstoquePecaController {

	@Autowired
	private EstoquePecaService estoquePecaService;
	
	@GetMapping()
	public List<EstoquePecaDTO> buscarPecas(){
		return estoquePecaService.findAll();
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<?> atualizarPeca(@RequestBody EstoquePecaDTO dto){
		return estoquePecaService.atualizarPeca(dto);
	}
	
	@GetMapping("/{id}")
	public EstoquePeca buscarPecaById(@PathVariable Long id) {
		return estoquePecaService.buscarPecaById(id);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> criarPeca(@RequestBody EstoquePecaDTO estoquePecaDTO){
		estoquePecaService.salvar(estoquePecaDTO);
		return ResponseEntity.ok("Peça salva no banco de dados.");
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> deletarPeca(@PathVariable Long id){
		estoquePecaService.deletarPeca(id);
		return ResponseEntity.ok("Peça excluída com sucesso.");
	}
}
