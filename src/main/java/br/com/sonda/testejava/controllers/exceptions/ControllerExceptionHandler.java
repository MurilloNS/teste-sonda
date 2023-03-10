package br.com.sonda.testejava.controllers.exceptions;

import br.com.sonda.testejava.services.exceptions.CnpjAlreadyExist;
import br.com.sonda.testejava.services.exceptions.EmpresaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(CnpjAlreadyExist.class)
    public ResponseEntity<StandardError> cnpjAlreadyExist(CnpjAlreadyExist e, HttpServletRequest request) {
        StandardError error = StandardError.builder().timestamp(LocalDateTime.now()).status(HttpStatus.CONFLICT.value())
                .error(e.getMessage()).path(request.getRequestURI()).build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(EmpresaNotFoundException.class)
    public ResponseEntity<StandardError> empresaNotFound(EmpresaNotFoundException e, HttpServletRequest request) {
        StandardError error = StandardError.builder().timestamp(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value())
                .error(e.getMessage()).path(request.getRequestURI()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
