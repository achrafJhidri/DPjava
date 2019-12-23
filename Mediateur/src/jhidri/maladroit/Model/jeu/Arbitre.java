package jhidri.maladroit.Model.jeu;

/**
 * Arbitre d'une partie de Shifumi
 * */
public class Arbitre
{
public static final int GAGNE = 0;

public static final int MATCH_NUL = 1;


/**
 * r�alise l'arbitrage d'une partie de Shifumi
 * 
 * @param coupShifumi[] : le tableau � deux �l�ments contenant les coups jou�s par le joueur 0 et par le joueur 1 
 *
 * @return une des 2 valeurs : GAGNE ou MATCH_NUL
 * 
 * Important :
 * 1) modifie les attributs miseJouee des �l�ments du tableau coupShifumi suivant les r�gles d�finies par les classes d�riv�es de CoupShifumi
 * 2) puis �change �ventuellement les �l�ments du tableau de telle sorte que le gagnant se retrouve toujours � la position 0.
 * En cas de match nul, ne change pas l'ordre des �l�ments
 * 
 */
public static int arbitrage(CoupShifumi coupShifumi[])
{

if (coupShifumi[0].matchNull(coupShifumi[1])) return MATCH_NUL;
else
    if (coupShifumi[0].gagne(coupShifumi[1])) return GAGNE;
    else
        {
        coupShifumi[1].gagne(coupShifumi[0]);       // calcule les cagnottes des 2 joueurs et le montant d�tenu par la banque
        
        // swap des 2 �l�ments
        
        CoupShifumi c = coupShifumi[0];
        coupShifumi[0] = coupShifumi[1];
        coupShifumi[1]= c;
        
        return GAGNE;
        }
}

}
