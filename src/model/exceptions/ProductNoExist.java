package model.exceptions;

public class ProductNoExist extends RuntimeException {
    public ProductNoExist(String message) {
        super(message);
    }
}
