package br.com.diego.sample.microsevicesample.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.diego.sample.microsevicesample.exceptions.CnpjJaExisteException;
import br.com.diego.sample.microsevicesample.exceptions.RecursoNaoEncontradoException;
import br.com.diego.sample.microsevicesample.mapper.EmpresaMapper;
import br.com.diego.sample.microsevicesample.model.dto.EmpresaDTO;
import br.com.diego.sample.microsevicesample.model.entity.Empresa;
import br.com.diego.sample.microsevicesample.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaMapper empresaMapper;
	
	public Page<Empresa> consultaTodas(Pageable pageable){
		
		return this.empresaRepository.findAll(pageable);
	}
	
	public EmpresaDTO consultaPorId(Integer id) {
		
		Optional<Empresa> empresaOptional = this.empresaRepository.findById(id);
		
		
		if(!empresaOptional.isEmpty()) {
			return this.empresaMapper.entityToDto(empresaOptional.get());
		}

		throw new RecursoNaoEncontradoException("Não existe empresa com este id.");
	}
	
	public EmpresaDTO consultaPorCnpj(String cnpj) {
		
		Optional<Empresa> empresaOptional = this.empresaRepository.findByCnpj(cnpj);
		
		if(!empresaOptional.isEmpty()) {
			return this.empresaMapper.entityToDto(empresaOptional.get());
		}

		throw new RecursoNaoEncontradoException("Não existe empresa com este cnpj.");
	}
	
	public EmpresaDTO cadastra(EmpresaDTO empresaDTO) {
		
		Optional<Empresa> empresaAux = this.empresaRepository.findByCnpj(empresaDTO.getCnpj());
		
		if(empresaAux.isPresent()) {
			throw new CnpjJaExisteException("Nossa base já possuí uma empresa com este cnpj.");
		}
		
		Empresa empresa = this.empresaRepository.save(this.empresaMapper.dtoToEntity(empresaDTO));
		
		return this.empresaMapper.entityToDto(empresa);
	}
	
	public EmpresaDTO atualiza(EmpresaDTO empresaDTO) {
		
		EmpresaDTO empresaAux = this.consultaPorId(empresaDTO.getId());
		empresaAux.setDataEdicao(new Date());
		
		Empresa empresa = this.empresaRepository.save(this.empresaMapper.dtoToEntity(empresaAux));
		
		return this.empresaMapper.entityToDto(empresa);
	}
	
	public Boolean deletaPorId(@PathVariable("id") Integer id) {
		
		EmpresaDTO empresaDTO = this.consultaPorId(id);
		
		this.empresaRepository.deleteById(empresaDTO.getId());
		
		return true;
	}
}
