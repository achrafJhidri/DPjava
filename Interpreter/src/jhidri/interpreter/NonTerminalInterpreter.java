package jhidri.interpreter;

import jhidri.expressions.Expression;
import jhidri.expressions.ExpressionBinaire;
import jhidri.operations.OperateurBinaire;



public  abstract class NonTerminalInterpreter implements Interpreter {

    public Expression parseCommun(StringBuffer s )
    {
        Expression gauche = parseGauche(s);//
        Interpreter.mangeBlancs(s);
        if (s.length() > 0 && s.charAt(0) == this.getOperator().toString().charAt(0))//+  || *
        {
            s.deleteCharAt(0);
            return new ExpressionBinaire(gauche,this.getOperator(),parseCommun(s));
        }
        else return gauche;
    }

    protected abstract OperateurBinaire getOperator();

    protected abstract Expression parseGauche(StringBuffer s);

    @Override
    public Expression interpreter(StringBuffer data)  {
        return parseCommun(data);
    }
}
