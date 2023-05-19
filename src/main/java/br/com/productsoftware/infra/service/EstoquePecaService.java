package br.com.productsoftware.infra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.productsoftware.infra.domain.EstoquePeca;
import br.com.productsoftware.infra.dto.EstoquePecaDTO;
import br.com.productsoftware.infra.mapper.EstoquePecaMapper;
import br.com.productsoftware.infra.repository.EstoquePecaRepository;

@Service
public class EstoquePecaService {

	@Autowired
	private EstoquePecaRepository estoquePecaRepository;
	
	@Autowired
	private EstoquePecaMapper mapper;
	
	public List<EstoquePecaDTO> findAll(){
		List<EstoquePeca> lista = estoquePecaRepository.findAll();
		List<EstoquePecaDTO> listaDTO = new ArrayList<EstoquePecaDTO>();
		if(!lista.isEmpty()) {
			for(EstoquePeca t : lista) {
				EstoquePecaDTO dto = mapper.domainToDTO(t);
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}
	
	public void salvar(EstoquePecaDTO dto) {
		EstoquePeca estoquePeca = mapper.toDomain(dto);
		estoquePecaRepository.save(estoquePeca);
	}
	
	public void deletarPeca(Long id) {
		EstoquePeca estoquePeca = estoquePecaRepository.findById(id).get();
		if(estoquePeca != null) {
			estoquePecaRepository.deleteById(id);
		}
	}
	
	public EstoquePeca buscarPecaById(Long id) {
		return estoquePecaRepository.findById(id).get();
	}

	public ResponseEntity<?> atualizarPeca(EstoquePecaDTO dto) {
		EstoquePeca pecaExistente = this.buscarPecaById(dto.getId());
		pecaExistente = mapper.atualizaPeca(pecaExistente, dto);
		estoquePecaRepository.save(pecaExistente);
		return ResponseEntity.ok().body("Alterações salvas no banco de dados.");
	}
}
