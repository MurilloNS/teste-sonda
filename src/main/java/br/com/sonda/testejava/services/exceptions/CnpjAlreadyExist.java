package br.com.sonda.testejava.services.exceptions;

public class CnpjAlreadyExist extends RuntimeException {
    public CnpjAlreadyExist(String message) {
        super(message);
    }
}
