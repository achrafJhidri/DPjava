package jhidri.interpreter;

import jhidri.expressions.Constante;
import jhidri.expressions.Expression;
import jhidri.expressions.Variable;

public class AtomiqueInterpreter extends TerminalExpression {
    @Override
    public Expression interpreter(StringBuffer data) {
        if ( data.length() == 0 ) throw new IllegalArgumentException("data is empty");
        char c = data.charAt(0);
        data.deleteCharAt(0);

        if(Character.isDigit(c)){
            return new Constante(c);
        }
        else if (c=='x')
        {
            return new Variable();
        }
        else {
            if (c != '(') throw new IllegalArgumentException("parenthese ( manquante");
            Expression result = new SommeInterpreter().interpreter(data);
            //kik spaces
            if(!(data.length()>0 && data.charAt(0)==')'))  throw new IllegalArgumentException("parenthese ) manquante");
            data.deleteCharAt(0);
            return result ;
        }

    }
}
