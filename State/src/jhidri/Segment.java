package jhidri;

import java.awt.*;

/**
 * Représente un segment à coordonnées entières dans le plan
 * 
 *  de la forme [AB] où A et B sont deux points de la forme A(x,y) et B(x,y)
 *  
 * */
public class Segment
{
public Point A, B;



/**
 * @param a
 * @param b
 */
public Segment(Point a, Point b)
{
this.A = a;
this.B = b;
}


/**
 * crée le segment dégénéré [A(0,0) B(0,0)]
 * 
 * */
public Segment()
{
this.A = new Point(); this.B = new Point();
}


/**
 * trace le segment this à l'aide du "crayon" g et de la couleur color 
 * 
 * Cette méthode peut être aussi bien utilisée pour dessiner que pour effacer
 * 
 * @param g : le crayon pour dessiner
 * 
 * @param color : couleur du tracé
 * 
 * */
public void trace(Graphics g, Color color)
{
Color couleurAvant = g.getColor();
g.setColor(color);
g.drawLine(A.x, A.y, B.x, B.y);
g.setColor(couleurAvant);
}

public String toString()
{
return "["+Segment.toString(A)+", "+Segment.toString(B)+"]";
}



private static String toString(Point a)
{
return "("+a.x+", "+a.y+")";
}


/**
 * 
 * remplit this.B en faisant une recopie du paramètre B
 * 
 * @param B : le paramètre à recopier
 * 
 * */
public void setB(Point B)
{
this.setB( B.x, B.y);
}



public void setB(int x, int y)
{
this.B.x = x; this.B.y = y;
}



public void setA(int x, int y)
{
this.A.x = x; this.A.y = y;
}

}
