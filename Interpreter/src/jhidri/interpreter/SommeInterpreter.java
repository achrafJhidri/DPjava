package jhidri.interpreter;

import jhidri.expressions.Expression;
import jhidri.operations.OperateurBinaire;
import jhidri.operations.Plus;

public class SommeInterpreter extends NonTerminalInterpreter {


    @Override
    protected OperateurBinaire getOperator() {
        return new Plus();
    }

    @Override
    protected Expression parseGauche(StringBuffer s) {
        return new ProduitInterpreter().interpreter(s);
    }
}
