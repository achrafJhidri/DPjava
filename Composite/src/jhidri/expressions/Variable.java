package jhidri.expressions;

import jhidri.expressions.Expression;

public class Variable extends Expression {
    private String name ;
    public Variable(String nom){
        super();
        if ( nom == null ||nom.trim().isEmpty() || nom.length() > 1 )
            throw new IllegalArgumentException("nom de variable invalide");
        name=nom;
    }



    @Override
    public double evaluer(double x) {
        return x;
    }

    @Override
    public String toString() {
        return name;
    }
}
