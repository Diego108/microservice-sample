package br.com.diego.sample.microsevicesample.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MensagemDTO implements Serializable {

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 1L;

	private String mensagemUsuario;
	
	private String mensagemDesenvolvedor;
	
	public MensagemDTO(String mensagemUsuario, String mensagemDesenvolvedor) {
		
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
}
