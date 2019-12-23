package jhidri.maladroit.Model.jeu;

/**
 * Arbitre d'une partie de Shifumi
 * */
public class Arbitre
{
public static final int GAGNE = 0;

public static final int MATCH_NUL = 1;


/**
 * réalise l'arbitrage d'une partie de Shifumi
 * 
 * @param coupShifumi[] : le tableau à deux éléments contenant les coups joués par le joueur 0 et par le joueur 1 
 *
 * @return une des 2 valeurs : GAGNE ou MATCH_NUL
 * 
 * Important :
 * 1) modifie les attributs miseJouee des éléments du tableau coupShifumi suivant les règles définies par les classes dérivées de CoupShifumi
 * 2) puis échange éventuellement les éléments du tableau de telle sorte que le gagnant se retrouve toujours à la position 0.
 * En cas de match nul, ne change pas l'ordre des éléments
 * 
 */
public static int arbitrage(CoupShifumi coupShifumi[])
{

if (coupShifumi[0].matchNull(coupShifumi[1])) return MATCH_NUL;
else
    if (coupShifumi[0].gagne(coupShifumi[1])) return GAGNE;
    else
        {
        coupShifumi[1].gagne(coupShifumi[0]);       // calcule les cagnottes des 2 joueurs et le montant détenu par la banque
        
        // swap des 2 éléments
        
        CoupShifumi c = coupShifumi[0];
        coupShifumi[0] = coupShifumi[1];
        coupShifumi[1]= c;
        
        return GAGNE;
        }
}

}
