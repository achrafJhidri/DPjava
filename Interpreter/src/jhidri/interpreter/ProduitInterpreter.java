package jhidri.interpreter;

import jhidri.expressions.Expression;
import jhidri.expressions.ExpressionBinaire;
import jhidri.operations.Fois;
import jhidri.operations.OperateurBinaire;

public class ProduitInterpreter extends NonTerminalInterpreter {


    @Override
    protected OperateurBinaire getOperator() {
        return new Fois();
    }

    @Override
    protected Expression parseGauche(StringBuffer s) {
        return new FacteurInterpreter().interpreter(s);
    }
}
