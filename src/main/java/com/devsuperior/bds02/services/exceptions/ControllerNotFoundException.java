package com.devsuperior.bds02.services.exceptions;

public class ControllerNotFoundException extends RuntimeException {
    
    
    private static final long serialVersionUID = -6535986182795330682L;
    
    public ControllerNotFoundException(String message) {
        super(message);
    }
    
}
