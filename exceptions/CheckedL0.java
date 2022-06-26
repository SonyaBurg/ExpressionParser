package expression.exceptions;

import expression.GeneralExpression;

public class CheckedL0 extends UnaryOps {
    public CheckedL0(GeneralExpression exp) {
        super(exp);
    }
    @Override
    protected int calculate(int a) {
        String bin = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        int i = 0;
        while (i < 32 && bin.charAt(i) == '0') {
            i += 1;
        }
        return i;
    }
    @Override
    public String toString() {
        return "l0(" + exp.toString() + ")";
    }
}
