package com.devsuperior.bds02.services.exceptions;

public class DatabaseException extends RuntimeException {
    
    private static final long serialVersionUID = -7588398386394324539L;
    
    public DatabaseException(String message) {
        super(message);
    }
    
}
