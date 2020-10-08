package br.com.diego.sample.microsevicesample.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

	/**
	 * @serialField
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@Column(name = "cnpj", unique = true)
	private String cnpj;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "data_edicao")
	private Date dataEdicao;
	
	@PrePersist
	private void preCadastro(){
		
		this.dataCadastro = new Date();
	}
	
	@PreUpdate
	private void preExclusao() {
		
		this.dataEdicao = new Date();
	}
}
