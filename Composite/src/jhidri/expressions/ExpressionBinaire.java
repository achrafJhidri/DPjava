package jhidri.expressions;

import jhidri.operations.OperateurBinaire;

public class ExpressionBinaire extends ExpressionComplexe {
    protected Expression gauche ;
    protected OperateurBinaire operateur ;
    protected Expression droite ;

    public ExpressionBinaire(Expression gauche,OperateurBinaire op,Expression droite){
        super(op);
        if(gauche == null ||droite ==null )
            throw new IllegalArgumentException("Operande invalide");
        this.gauche = gauche;
        this.droite = droite;
        this.operateur=op;
    }

    @Override
    public double evaluer(double x) {
        return operateur.evaluer(gauche.evaluer(x),droite.evaluer(x));
    }


    @Override
    public String toString() {
        return "("+ gauche+" "+operateur.toString()+" "+droite +")";
    }
}
