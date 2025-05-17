package model.exceptions;

public class NameExist extends RuntimeException {
    public NameExist(String message) {
        super(message);
    }
}
