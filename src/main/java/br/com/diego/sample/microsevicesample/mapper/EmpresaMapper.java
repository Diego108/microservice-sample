package br.com.diego.sample.microsevicesample.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.diego.sample.microsevicesample.model.dto.EmpresaDTO;
import br.com.diego.sample.microsevicesample.model.entity.Empresa;

@Component
public class EmpresaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Empresa dtoToEntity(EmpresaDTO empresaDTO) {
		
		return this.modelMapper.map(empresaDTO, Empresa.class);
	}
	
	public EmpresaDTO entityToDto(Empresa empresa) {
		
		return this.modelMapper.map(empresa, EmpresaDTO.class);
	}
	
	public Page<EmpresaDTO> pageEntityToDto(Page<Empresa> pageEntity) {
		
		@SuppressWarnings("unchecked")
		Class<Page<EmpresaDTO>> empresaDTO = (Class<Page<EmpresaDTO>>) new Object();
		
		return this.modelMapper.map(pageEntity, empresaDTO);
	}
	
	public Page<Empresa> pageDtoToEntity(Page<EmpresaDTO> pageDto) {
		
		@SuppressWarnings("unchecked")
		Class<Page<Empresa>> empresa = (Class<Page<Empresa>>) new Object();
		
		return this.modelMapper.map(pageDto, empresa);
	}
}
