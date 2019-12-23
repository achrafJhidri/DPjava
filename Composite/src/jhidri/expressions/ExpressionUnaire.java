package jhidri.expressions;

import jhidri.operations.Operateur;
import jhidri.operations.OperateurUnaire;

public class ExpressionUnaire extends ExpressionComplexe {

    protected OperateurUnaire operateur;
    protected Expression operande;
    public ExpressionUnaire(OperateurUnaire op, Expression operande) {
        super(op);
        if(operande == null)
            throw new IllegalArgumentException("Operande invalide");
        this.operande=operande;
        this.operateur=op;

    }

    @Override
    public double evaluer(double x) {
        return operateur.evaluer(operande.evaluer(x));
    }

    @Override
    public String toString() {
        return operateur+" "+operande;
    }
}
