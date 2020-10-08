package br.com.diego.sample.microsevicesample.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diego.sample.microsevicesample.model.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

	public Page<Empresa> findAll(Pageable pageable);
	
	public Optional<Empresa> findByCnpj(String cnpj);
}
