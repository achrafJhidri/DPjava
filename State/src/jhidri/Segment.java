package jhidri;

import java.awt.*;

/**
 * Repr�sente un segment � coordonn�es enti�res dans le plan
 * 
 *  de la forme [AB] o� A et B sont deux points de la forme A(x,y) et B(x,y)
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
 * cr�e le segment d�g�n�r� [A(0,0) B(0,0)]
 * 
 * */
public Segment()
{
this.A = new Point(); this.B = new Point();
}


/**
 * trace le segment this � l'aide du "crayon" g et de la couleur color 
 * 
 * Cette m�thode peut �tre aussi bien utilis�e pour dessiner que pour effacer
 * 
 * @param g : le crayon pour dessiner
 * 
 * @param color : couleur du trac�
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
 * remplit this.B en faisant une recopie du param�tre B
 * 
 * @param B : le param�tre � recopier
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
