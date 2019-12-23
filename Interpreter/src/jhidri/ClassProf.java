package jhidri;

import jhidri.expressions.Constante;
import jhidri.expressions.Expression;
import jhidri.expressions.ExpressionBinaire;
import jhidri.expressions.Variable;
import jhidri.operations.Fois;
import jhidri.operations.Plus;

import java.text.ParseException;




/**
 *
 * contient les fonctionnalit�s n�cessaires � la transformation d'une cha�ne de caract�res contenant une expression alg�brique
 * en un arbre syntaxique (cf. exocomposite).
 *
 * Dans un souci de simplification du probl�me :
 * Nous faisons les hypoth�ses suivantes :
 *
 * 1) Les seuls caract�res admis dans la cha�ne � analyser sont :
 *
 *      + * ( ) x 0 1 2 3 4 5 6 7 8 9
 *      et le caract�re espace
 *
 *
 * 2) Les nombres sont limit�s � un chiffre. Les seuls nombres admis sont donc les entiers naturels compris entre 0 et 9.
 *
 * Par ailleurs, l'algorithme d'analyse respecte les contraintes suivantes :
 *
 * La cha�ne est analys�e caract�re par caract�re, de gauche � droite
 *
 * et Tout caract�re trait� avec succ�s est effac� dans la cha�ne de caract�res.
 *
 * L'analyse s'arr�te d�s qu'elle ne reconna�t pas un �l�ment pr�vu par la grammaire
 *
 * L'id�e g�n�rale est d'�crire une m�thode d'analyse pour chaque ligne de la grammaire, ce qui a conduit � la solution propos�e
 *
 *
 * */
public class ClassProf
{


    public static Expression parseSomme(StringBuffer s ) throws ParseException
    {
        Expression gauche = parseProduit(s);
        mangeBlancs(s);
        if (s.length() > 0 && s.charAt(0) == '+')
        {
            s.deleteCharAt(0);
            return new ExpressionBinaire(gauche,new Plus(),parseSomme(s));
        }
        else return gauche;
    }

    public static Expression parseProduit(StringBuffer s) throws ParseException
    {
        Expression gauche = parseFacteur(s);
        mangeBlancs(s);
        if (s.length() > 0 && s.charAt(0) == '*')
        {
            s.deleteCharAt(0);
            return new ExpressionBinaire(gauche,new Fois(),parseProduit(s));
        }
        else return gauche;
    }


    public static Expression parseFacteur(StringBuffer s) throws ParseException
    {
        mangeBlancs(s);

        if (s.length() == 0) throw new ParseException("facteur attendu", -1);

        char c = s.charAt(0);
        s.deleteCharAt(0);
        if (c == 'x')
            return new Variable();
        else
        if (Character.isDigit(c))
            return new Constante(Character.getNumericValue(c));
        else
        {
            if (c != '(') throw new ParseException("( attendue", -1);
            Expression r = parseSomme(s);
            mangeBlancs(s);

            if (!(s.length() > 0 && s.charAt(0) == ')')) throw new ParseException(") attendue", -1);
            s.deleteCharAt(0);
            return r;
        }
    }

    public static void mangeBlancs(StringBuffer s)
    {
//System.err.println(s);

    }


}
