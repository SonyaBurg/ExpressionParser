package expression.exceptions;

public class ParseOperationException extends ParseException {
    public ParseOperationException(String message) {
        super(message);
    }
    public ParseOperationException(String message, Throwable cause) {
        super(message, cause);
    }

}
