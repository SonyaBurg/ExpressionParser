package expression.exceptions;

import expression.GeneralExpression;
import expression.Operation;
import expression.OperationType;

public class CheckedMultiply extends CheckedOperation {
    public CheckedMultiply(GeneralExpression l, GeneralExpression r) {
        super(l, r, OperationType.MULTIPLY);
    }

    protected int calculate(int x, int y) {
        if (x != 0 && y != 0)
            if ((x * y) / x != y || (x * y) / y != x)
            throw new ParseOverflowException("overflow");
        return x * y;
    }
}
