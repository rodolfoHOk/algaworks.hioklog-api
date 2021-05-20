package br.com.hioktec.hioklog.api.model.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.hioktec.hioklog.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaResponse {
	
	private Long id;
	private ClienteResumoResponse cliente;
	private DestinatarioResponse destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
}
