package br.com.diego.sample.microsevicesample.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmpresaDTO implements Serializable {
	
	/**
	 * @serialField 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull
	private String razaoSocial;
	
	@NotNull
	private String cnpj;
	
	private boolean ativo;
	
	private Date dataCadastro;
	
	private Date dataEdicao;
}
