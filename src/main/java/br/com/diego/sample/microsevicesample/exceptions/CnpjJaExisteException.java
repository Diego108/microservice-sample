package br.com.diego.sample.microsevicesample.exceptions;

public class CnpjJaExisteException extends RuntimeException {

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 1L;

	public CnpjJaExisteException(String msg) {
		super(msg);
	}
	
}
