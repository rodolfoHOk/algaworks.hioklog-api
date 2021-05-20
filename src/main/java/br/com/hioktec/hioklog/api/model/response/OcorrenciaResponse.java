package br.com.hioktec.hioklog.api.model.response;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaResponse {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
}
