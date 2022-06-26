package expression.exceptions;
import expression.OperationType;
import expression.GeneralExpression;

public class CheckedMax extends CheckedOperation {
    public CheckedMax(GeneralExpression l, GeneralExpression r) {
        super(l, r, OperationType.MAX);
    }

    @Override
    protected int calculate(int x, int y) {
        return x >= y ? x : y;
    }
}
