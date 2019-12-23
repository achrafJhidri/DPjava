package jhidri.interpreter;

import jhidri.expressions.Expression;
import jhidri.expressions.ExpressionUnaire;
import jhidri.operations.Cosinus;
import jhidri.operations.OperateurBinaire;
import jhidri.operations.OperateurUnaire;
import jhidri.operations.Sinus;

import java.util.HashMap;

public class FacteurInterpreter extends TerminalExpression {

    HashMap<String , OperateurUnaire> functions ;
    public FacteurInterpreter(){
        functions.put("sin",new Sinus());
        functions.put("cos",new Cosinus());


    }
    @Override
    public Expression interpreter(StringBuffer data) {
        //kik spaces
        int indexOfSpace= data.indexOf(" ");
      String premierMorceau = data.substring(0,indexOfSpace);
      String deuxiemeMorceau= data.substring(indexOfSpace);
      if ( premierMorceau.equals("") || deuxiemeMorceau.equals(""))
          throw new IllegalArgumentException("function's name or atomique part is empty");

        OperateurUnaire gauche = functions.get(premierMorceau);
        Expression e= new AtomiqueInterpreter().interpreter(data);
        return new ExpressionUnaire(gauche,e);
    }


}
