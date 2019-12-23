package jhidri.operations;

import static java.lang.Math.*;
import jhidri.expressions.Expression;

public class Puissance extends OperateurUnaire {
    protected Expression puissance ;
    public Puissance(Expression puissance ){
        super();
        this.puissance=puissance;
    }
    @Override
    public double evaluer(double param) {
        return exp(puissance.evaluer(param)*log(param));
    }

    @Override
    public String toString() {
        return "pow"+puissance;
    }
}
