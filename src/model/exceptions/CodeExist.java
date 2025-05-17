package model.exceptions;

public class CodeExist extends RuntimeException {
    public CodeExist(String message) {
        super(message);
    }
}
