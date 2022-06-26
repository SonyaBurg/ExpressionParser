package expression.exceptions;

import expression.GeneralExpression;
import expression.OperationType;

public class CheckedAdd extends CheckedOperation {
    public CheckedAdd(GeneralExpression l, GeneralExpression r) {
        super(l, r, OperationType.ADD);
    }

    protected int calculate(int x, int y) {
        if (x + y <= 0 && x > 0 && y > 0 || x + y >= 0 && y < 0 && x < 0) {
            throw new ParseOverflowException("overflow");
        }
        return x + y;
    }
}


