package br.com.hioktec.hioklog.domain.service;

import org.springframework.stereotype.Service;

import br.com.hioktec.hioklog.domain.exception.EntidadeNaoEncontradaException;
import br.com.hioktec.hioklog.domain.model.Entrega;
import br.com.hioktec.hioklog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	
}
