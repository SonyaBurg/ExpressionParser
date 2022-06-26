package expression.exceptions;

import expression.GeneralExpression;

public class CheckedT0 extends UnaryOps {
    public CheckedT0(GeneralExpression exp) {
        super(exp);
    }
    @Override
    protected int calculate(int a) {
        String bin = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        int i = 31;
        while (i >= 0 && bin.charAt(i) == '0') {
            i -= 1;
        }
        return 31 - i;
    }
    @Override
    public String toString() {
        return "t0(" + exp.toString() + ")";
    }
}
