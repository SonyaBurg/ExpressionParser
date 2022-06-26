package expression.exceptions;

public class ParseParenthesesException extends RuntimeException {
    public ParseParenthesesException(String message) {
        super(message);
    }
    public ParseParenthesesException(String message, Throwable cause) {
        super(message, cause);
    }

}
