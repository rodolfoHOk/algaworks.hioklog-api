package br.com.hioktec.hioklog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hioktec.hioklog.api.assembler.ClienteAssembler;
import br.com.hioktec.hioklog.api.model.request.ClienteRequest;
import br.com.hioktec.hioklog.api.model.response.ClienteResponse;
import br.com.hioktec.hioklog.domain.model.Cliente;
import br.com.hioktec.hioklog.domain.repository.ClienteRepository;
import br.com.hioktec.hioklog.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	
	private CatalogoClienteService catalogoClienteService;
	
	private ClienteAssembler clienteAssembler;
	
	@GetMapping
	public List<ClienteResponse> listar() {
		return clienteAssembler.toCollectionModel(clienteRepository.findAll());
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClienteResponse> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.ok(clienteAssembler.toModel(cliente)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse adicionar(@Valid @RequestBody ClienteRequest clienteRequest) {
		Cliente clienteSalvo = catalogoClienteService.salvar(clienteAssembler.toEntity(clienteRequest));
		
		return clienteAssembler.toModel(clienteSalvo);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long clienteId, @Valid @RequestBody ClienteRequest clienteRequest){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente cliente = clienteAssembler.toEntity(clienteRequest);
		cliente.setId(clienteId);
		
		var clienteSalvo = catalogoClienteService.salvar(cliente);
		
		return ResponseEntity.ok(clienteAssembler.toModel(clienteSalvo));
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		catalogoClienteService.excluir(clienteId);
		
		return ResponseEntity.noContent().build();
	}
	
}
