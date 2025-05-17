package model.exceptions;

public class ValueBelowZero extends RuntimeException {
    public ValueBelowZero(String message) {
        super(message);
    }
}
