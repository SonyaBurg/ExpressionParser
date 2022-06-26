package expression.exceptions;

import expression.GeneralExpression;

public abstract class UnaryOps implements GeneralExpression {
    public GeneralExpression exp;
    public UnaryOps(GeneralExpression exp) {
        this.exp = exp;
    }
    protected abstract int calculate(int a);
    @Override
    public int evaluate(int x) {
        return calculate(exp.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(exp.evaluate(x, y, z));
    }
}
