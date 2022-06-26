package expression.exceptions;

public class ParseOverflowException extends ParseException {
    public ParseOverflowException(String message) {
        super(message);
    }

    public ParseOverflowException(Throwable cause) {
        super("overflow", cause);
    }
}
