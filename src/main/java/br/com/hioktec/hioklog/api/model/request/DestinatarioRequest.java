package br.com.hioktec.hioklog.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	
	private String complemento;
	
	@NotBlank
	private String bairro;
	
}
