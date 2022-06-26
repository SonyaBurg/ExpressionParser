package expression.exceptions;

import expression.GeneralExpression;
import expression.OperationType;

public class CheckedMin extends CheckedOperation {
    public CheckedMin(GeneralExpression l, GeneralExpression r) {
        super(l, r, OperationType.MIN);
    }

    @Override
    protected int calculate(int x, int y) {
        return x >= y ? y : x;
    }
}
