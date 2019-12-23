package jhidri.interpreter;

import jhidri.expressions.Expression;

import java.text.ParseException;

public interface Interpreter {
    Expression interpreter(StringBuffer data) throws ParseException;

    static void mangeBlancs(StringBuffer s){
        String string = s.toString();
        string.trim();
        String[] parts= string.split(" ");
        s.delete(0,s.length());
        for(String part : parts ){
            s.append(part);
        }
    }
}
