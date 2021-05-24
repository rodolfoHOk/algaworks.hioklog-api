package br.com.hioktec.hioklog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hioktec.hioklog.api.model.request.ClienteRequest;
import br.com.hioktec.hioklog.api.model.response.ClienteResponse;
import br.com.hioktec.hioklog.domain.model.Cliente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ClienteAssembler {
	
	private ModelMapper modelMapper;
	
	public ClienteResponse toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteResponse.class);
	}
	
	public List<ClienteResponse> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Cliente toEntity(ClienteRequest clienteRequest) {
		return modelMapper.map(clienteRequest, Cliente.class);
	}
	
}
