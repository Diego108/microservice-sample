package br.com.diego.sample.microsevicesample.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontradoException(String msg) {
		
		super(msg);
	}
}
