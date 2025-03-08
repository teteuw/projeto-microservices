package br.com.teteu.api.gateway.exceptions;

import java.io.Serializable;
import java.sql.Date;

public class ExceptionResponse implements Serializable{
    private static final long serialVersion = 1L;
    
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public static long getSerialversion() {
        return serialVersion;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
    
    
}
