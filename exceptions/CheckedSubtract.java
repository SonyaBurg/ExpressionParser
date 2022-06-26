package expression.exceptions;

import expression.GeneralExpression;
import expression.OperationType;

public class CheckedSubtract extends CheckedOperation {
    public CheckedSubtract(GeneralExpression l, GeneralExpression r) {
        super(l, r, OperationType.SUBTRACT);
    }

    protected int calculate(int x, int y) {
        if ((x - y) <= 0 && x > y || (x - y) >= 0 && x < y) {
            throw new ParseOverflowException("overflow");
        }
        return x - y;
    }
}

