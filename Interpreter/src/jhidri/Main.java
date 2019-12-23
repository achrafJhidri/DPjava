package jhidri;

import jhidri.expressions.*;
import jhidri.interpreter.Interpreter;
import jhidri.operations.Fois;
import jhidri.operations.Oppose;
import jhidri.operations.Plus;
import jhidri.operations.Puissance;


public class Main {

    public static void main(String[] args) {
        Expression f1=new Constante(7);


        Expression var=new Variable();
        Expression f2 = new ExpressionUnaire(new Oppose(),var);


        Expression constante = new Constante(5.2);

        Expression xCarre = new ExpressionUnaire(new Puissance(new Constante(2)),var);
        Expression xCarrePlus1 = new ExpressionBinaire(xCarre,new Plus(),new Constante(1));
        Expression xCarrePlus1LeToutPuissance5 = new ExpressionUnaire(new Puissance(new Constante(5)),xCarrePlus1);
        Expression f5=new ExpressionBinaire(constante,new Fois(),xCarrePlus1LeToutPuissance5);

        System.out.println(f5.evaluer(1));




        StringBuffer sb = new StringBuffer("Hello my name is your fucking head");

        Interpreter.mangeBlanc(sb);

        System.out.println(sb);



    }
}
