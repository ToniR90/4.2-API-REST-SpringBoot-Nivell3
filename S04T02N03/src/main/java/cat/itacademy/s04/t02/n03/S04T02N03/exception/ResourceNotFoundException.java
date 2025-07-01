package cat.itacademy.s04.t02.n03.S04T02N03.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
