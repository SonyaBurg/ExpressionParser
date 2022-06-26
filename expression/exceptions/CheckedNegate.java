package expression.exceptions;

import expression.GeneralExpression;

public class CheckedNegate extends UnaryOps {
    public CheckedNegate(GeneralExpression l) {
        super(l);
    }

    @Override
    protected int calculate(int a) {
        if (a == Integer.MIN_VALUE) throw new ParseOverflowException("overflow");
        return -a;
    }
    @Override
    public String toString() {
        return "-("+exp.toString()+")";
    }


}

