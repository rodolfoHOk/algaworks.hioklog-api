package br.com.hioktec.hioklog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hioktec.hioklog.api.assembler.OcorrenciaAssembler;
import br.com.hioktec.hioklog.api.model.request.OcorrenciaRequest;
import br.com.hioktec.hioklog.api.model.response.OcorrenciaResponse;
import br.com.hioktec.hioklog.domain.model.Entrega;
import br.com.hioktec.hioklog.domain.model.Ocorrencia;
import br.com.hioktec.hioklog.domain.service.BuscaEntregaService;
import br.com.hioktec.hioklog.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private BuscaEntregaService buscaEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaResponse registar(@PathVariable Long entregaId, 
			@Valid @RequestBody OcorrenciaRequest ocorrenciaRequest) {
		Ocorrencia ocorrencia = registroOcorrenciaService.registrar(entregaId, ocorrenciaRequest.getDescricao());
		return ocorrenciaAssembler.toModel(ocorrencia);
	}
	
	@GetMapping
	public List<OcorrenciaResponse> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
}
