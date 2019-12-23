package jhidri.expressions;

import jhidri.expressions.Expression;

public class Variable extends Expression {
    private String name ="x";




    @Override
    public double evaluer(double x) {
        return x;
    }

    @Override
    public String toString() {
        return name;
    }
}
