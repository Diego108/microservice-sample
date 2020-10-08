package br.com.diego.sample.microsevicesample.config.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.diego.sample.microsevicesample.exceptions.CnpjJaExisteException;
import br.com.diego.sample.microsevicesample.exceptions.RecursoNaoEncontradoException;
import br.com.diego.sample.microsevicesample.model.dto.MensagemDTO;

@ControllerAdvice
public class HandleDeExcecao extends ResponseEntityExceptionHandler  {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler({ RecursoNaoEncontradoException.class })
	public ResponseEntity<Object> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		
		List<MensagemDTO> mensagensDeErro = Arrays.asList(new MensagemDTO(mensagemUsuario, mensagemDesenvolvedor));
		
		return handleExceptionInternal(ex, mensagensDeErro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ CnpjJaExisteException.class })
	public ResponseEntity<Object> handleCnpjJaExisteException(CnpjJaExisteException ex, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("recurso.cnpj-encontrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		
		List<MensagemDTO> mensagensDeErro = Arrays.asList(new MensagemDTO(mensagemUsuario, mensagemDesenvolvedor));
		
		return handleExceptionInternal(ex, mensagensDeErro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
