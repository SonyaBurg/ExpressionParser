package expression;

public class Variable implements GeneralExpression {
    private final String name;
    public Variable(String name) {
        this.name = name;
    }
    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return switch (this.name) {
            case "x" -> x;
            case "y" -> y;
            case "z" -> z;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object exp) {
        if (exp == this) return true;
        if (exp == null || this.getClass() != exp.getClass()) return false;
        return ((Variable) exp).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
