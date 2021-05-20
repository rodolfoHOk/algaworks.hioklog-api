package br.com.hioktec.hioklog.domain.exception;

public class EntidadeNaoEncontradaException extends RegraNegocioException{

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}
	
}
