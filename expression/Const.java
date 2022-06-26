package expression;

public class Const implements GeneralExpression {
    private final long value;
    public Const(int x) {
        this.value = x;
    }
    public Const(long x) {
        this.value = x;
    }

    @Override
    public int evaluate(int x) {
        return (int)value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int)value;
    }
    @Override
    public String toString() {
        return Long.toString(value);
    }

    @Override
    public boolean equals(Object exp) {
        if (exp == this) return true;
        if (exp == null || this.getClass() != exp.getClass()) return false;
        return ((Const) exp).value == this.value;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode((int)value) * 127;
    }
}
