package expression.exceptions;

import expression.*;

public class CheckedDivide extends CheckedOperation {
    public CheckedDivide(GeneralExpression l, GeneralExpression r) {
        super(l, r, OperationType.DIVIDE);
    }

    protected int calculate(int x, int y) {
        if (y == 0) throw new ParseDBZException("divide by zero");
        if (x == Integer.MIN_VALUE && y == -1) throw new ParseOverflowException("overflow");
            return x / y;
    }
}

