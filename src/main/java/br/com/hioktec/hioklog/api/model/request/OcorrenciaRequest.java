package br.com.hioktec.hioklog.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaRequest {
	
	@NotBlank
	private String descricao;

}
