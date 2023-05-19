package br.com.productsoftware.infra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.productsoftware.infra.domain.Balanca;
import br.com.productsoftware.infra.dto.BalancaDTO;
import br.com.productsoftware.infra.mapper.BalancaMapper;
import br.com.productsoftware.infra.repository.BalancaRepository;

@Service
public class BalancaService {

	@Autowired
	private BalancaRepository balancaRepository;
	
	@Autowired
	private BalancaMapper mapper;
	
	public List<BalancaDTO> findAll(){
		List<Balanca> lista = balancaRepository.findAll();
		List<BalancaDTO> listaDTO = new ArrayList<BalancaDTO>();
		if(!lista.isEmpty()) {
			for(Balanca t : lista) {
				BalancaDTO dto = mapper.domainToDTO(t);
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}
	
	public void salvar(BalancaDTO dto) {
		Balanca balanca = mapper.toDomain(dto);
		balancaRepository.save(balanca);
	}
	
	public List<Balanca> buscarBalancaByDoc(Long documento) {
		return balancaRepository.findByDocumentoProprietario(documento);
	}

	public void deletarBalanca(Long id) {
		Balanca balanca = balancaRepository.findById(id).get();
		if(balanca != null) {
			balancaRepository.deleteById(id);
		}
	}
	
	public Balanca buscarBalancaById(Long id) {
		return balancaRepository.findById(id).get();
	}
}
