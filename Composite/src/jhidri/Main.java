package jhidri;

import jhidri.expressions.*;
import jhidri.operations.*;

import java.sql.SQLOutput;


public class Main {

    public static void main(String[] args) {
        Expression f1=new Constante(7);


        Expression var=new Variable("x");
        Expression f2 = new ExpressionUnaire(new Oppose(),var);


        Expression constante = new Constante(5.2);

        Expression xCarre = new ExpressionUnaire(new Puissance(new Constante(2)),var);
        Expression xCarrePlus1 = new ExpressionBinaire(xCarre,new Plus(),new Constante(1));
        Expression xCarrePlus1LeToutPuissance5 = new ExpressionUnaire(new Puissance(new Constante(5)),xCarrePlus1);
        Expression f5=new ExpressionBinaire(constante,new Fois(),xCarrePlus1LeToutPuissance5);
        System.out.println(f5);
        System.out.println(f5.evaluer(1));

        Expression constante2 = new Constante(2);
        Expression  troisx = new ExpressionBinaire(new Constante(3),new Fois(),new Variable("x"));
        Expression f = new ExpressionBinaire(new ExpressionBinaire(troisx,new Soustraction(),constante2),new Fois(),constante2);

        System.out.println(f.evaluer(0));



    }
}
