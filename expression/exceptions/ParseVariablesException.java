package expression.exceptions;

public class ParseVariablesException extends RuntimeException {
    public ParseVariablesException(String s) {
        super(s);
    }
    public ParseVariablesException(String message, Throwable cause) {
        super(message, cause);
    }

}
