package org.example;

public class ServiceException extends Exception {
    private String messageException ;
    public ServiceException(String message){
        super();
    this.messageException = message;
    }
}
