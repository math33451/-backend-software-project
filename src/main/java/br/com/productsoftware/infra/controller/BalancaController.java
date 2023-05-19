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

import br.com.productsoftware.infra.domain.Balanca;
import br.com.productsoftware.infra.dto.BalancaDTO;
import br.com.productsoftware.infra.service.BalancaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/balanca")
public class BalancaController {

	@Autowired
	private BalancaService balancaService;
	
	@GetMapping()
	public List<BalancaDTO> buscarBalancas(){
		return balancaService.findAll();
	}
	
	@GetMapping("/doc/{documento}")
	public List<Balanca> buscarBalanca(@PathVariable Long documento) {
		return balancaService.buscarBalancaByDoc(documento);
	}
	
	@GetMapping("/{id}")
	public Balanca buscarBalancaById(@PathVariable Long id) {
		return balancaService.buscarBalancaById(id);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> criarBalanca(@RequestBody BalancaDTO balancaDTO){
		balancaService.salvar(balancaDTO);
		return ResponseEntity.ok("Balança salva no banco de dados.");
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> deletarBalanca(@PathVariable Long id){
		balancaService.deletarBalanca(id);
		return ResponseEntity.ok("Balança excluída com sucesso.");
	}
}
