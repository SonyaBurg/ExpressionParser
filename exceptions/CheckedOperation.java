package expression.exceptions;

import expression.GeneralExpression;
import expression.OperationType;

import java.util.Map;

public abstract class CheckedOperation implements GeneralExpression {
    private final GeneralExpression left;
    private final GeneralExpression right;
    private final OperationType operationType;
    private final Map<OperationType, String> typeMap = Map.of(
            OperationType.ADD, "+",
            OperationType.SUBTRACT, "-",
            OperationType.MULTIPLY, "*",
            OperationType.DIVIDE, "/",
            OperationType.MIN, "min",
            OperationType.MAX, "max"
    );

    public CheckedOperation(GeneralExpression l, GeneralExpression r, OperationType opType) {
        this.left = l;
        this.right = r;
        this.operationType = opType;
    }

    protected abstract int calculate(int x, int y);

    @Override
    public int evaluate(int x) {
            return calculate(this.left.evaluate(x), this.right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
            return calculate(this.left.evaluate(x, y, z), this.right.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + typeMap.get(operationType) + " " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            final CheckedOperation op = (CheckedOperation) obj;
            return left.equals(op.left) && right.equals(op.right) && operationType.equals(op.operationType);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return left.hashCode() * 11 + right.hashCode() * 7 + operationType.hashCode() * 3;
    }
}
