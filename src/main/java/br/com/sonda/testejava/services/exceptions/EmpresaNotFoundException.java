package br.com.sonda.testejava.services.exceptions;

public class EmpresaNotFoundException extends RuntimeException {
    public EmpresaNotFoundException(String message) {
        super(message);
    }
}
