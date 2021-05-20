package br.com.hioktec.hioklog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hioktec.hioklog.api.model.response.OcorrenciaResponse;
import br.com.hioktec.hioklog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

	private ModelMapper modelMapper;
	
	public OcorrenciaResponse toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaResponse.class);
	}
	
	public List<OcorrenciaResponse> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
