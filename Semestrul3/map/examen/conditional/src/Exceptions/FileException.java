package Exceptions;

public class FileException extends RuntimeException {
    public FileException(String message) {
        super(message);
    }

    public FileException() {
    }
}

