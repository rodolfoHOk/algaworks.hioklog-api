package br.com.hioktec.hioklog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hioktec.hioklog.api.model.request.EntregaRequest;
import br.com.hioktec.hioklog.api.model.response.EntregaResponse;
import br.com.hioktec.hioklog.domain.model.Entrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {
	
	private ModelMapper modelMapper;
	
	public EntregaResponse toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaResponse.class);
	}
	
	public List<EntregaResponse> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaRequest entregaRequest) {
		return modelMapper.map(entregaRequest, Entrega.class);
	}
	
}
