package br.edu.pratico02;

public class CpfAlreadyExistsException extends RuntimeException{
    public CpfAlreadyExistsException() {
        super();
    }

    public CpfAlreadyExistsException(String message) {
        super(message);
    }
}
