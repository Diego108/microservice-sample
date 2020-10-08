package br.com.diego.sample.microsevicesample.resources;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diego.sample.microsevicesample.model.dto.EmpresaDTO;
import br.com.diego.sample.microsevicesample.model.entity.Empresa;
import br.com.diego.sample.microsevicesample.services.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/empresa")
@Api(value = "Eventos API REST - Empresa Resource")
public class EmpresaResource {

    private static final Logger LOG = LoggerFactory.getLogger(EmpresaResource.class);
    
	@Autowired
	private EmpresaService empresaService;
	
	
	@GetMapping()
    @ApiOperation(value = "RETORNA TODAS EMPRESAS PAGINADAS", notes = "TODOS EMPRESAS SERÃO LISTADAS POR PAGINAÇÃO.")
	public ResponseEntity<Page<Empresa>> consultaTodas(@PageableDefault Pageable pageable) {
		
		LOG.info("BUSCANDO TODAS AS EMPRESAS POR CONSULATA PAGINADA");
		
		return ResponseEntity.ok(this.empresaService.consultaTodas(pageable));
	}

	@GetMapping("/{id}")
    @ApiOperation(value = "RETORNA CONSULTA DE EMPRESA POR ID", notes = "EMPRESA PESQUISADA POR UM DETERMINADO ID.")
	public ResponseEntity<EmpresaDTO> consultaPorId(@PathVariable("id") Integer id) {
		
		LOG.info("BUSCANDO A EMPRESA PARA O ID {}", id);
		
		EmpresaDTO empresa = this.empresaService.consultaPorId(id);
		
		return ResponseEntity.ok(empresa);
	}
	
	@GetMapping("/cnpj/{cnpj}")
    @ApiOperation(value = "RETORNA CONSULTA DE EMPRESA POR CNPJ", notes = "EMPRESA PESQUISADA POR UM DETERMINADO CNPJ.")
	public ResponseEntity<EmpresaDTO> consultaPorId(@PathVariable("cnpj") String cnpj) {
		
		LOG.info("BUSCANDO A EMPRESA PARA O CNPJ {}", cnpj);
		
		EmpresaDTO empresa = this.empresaService.consultaPorCnpj(cnpj);
		
		return ResponseEntity.ok(empresa);
	}
	
	@PostMapping()
    @ApiOperation(value = "CADASTRA UMA NOVA EMPRESA", notes = "PERMITE CADASTRAR UMA NOVA EMPRESA.")
	public ResponseEntity<EmpresaDTO> cadastra(@RequestBody @Valid EmpresaDTO empresa) {
		
		LOG.info("CADASTRA NOVA EMPRESA, DADOS {}", empresa);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.empresaService.cadastra(empresa));
	}
	
	@PutMapping()
    @ApiOperation(value = "ATUALIZA UMA NOVA EMPRESA", notes = "PERMITE ATUALIZAR UMA EMPRESA CADASTRADA.")
	public ResponseEntity<EmpresaDTO> atualiza(@RequestBody @Valid EmpresaDTO empresa) {

		LOG.info("ATUALIZA EMPRESA CADASTRADA, DADOS {}", empresa);
		
		return ResponseEntity.ok(this.empresaService.atualiza(empresa));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "DELETA UMA NOVA EMPRESA", notes = "PERMITE DELETAR UMA EMPRESA CADASTRADA.")
	public ResponseEntity<Void> deletaPorId(@PathVariable("id") Integer id) {

		LOG.info("DELETA EMPRESA CADASTRADA POR ID {}", id);
				
		this.empresaService.deletaPorId(id);
		
		return ResponseEntity.noContent().build();
	}
}
