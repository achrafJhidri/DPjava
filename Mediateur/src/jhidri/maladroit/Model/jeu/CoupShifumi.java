package jhidri.maladroit.Model.jeu;


import jhidri.maladroit.Model.Banque;

/**
 * Repr�sente un coup jou� au Shifumi
 * 
 * */
public abstract class CoupShifumi
{
public String pseudoJoueur;
public double miseJouee;

public Mediateur mediateur;

public CoupShifumi(String pseudoJoueur, double miseJouee, Mediateur mediateur)
{
super();
this.pseudoJoueur = pseudoJoueur;
this.miseJouee = miseJouee;

this.mediateur=mediateur;
}

/**
 * G�re les calculs de gain si this gagne contre coupShifumi, ne g�re rien si this perd ou si this fait un match nul
 *
 * @param coupShifumi : le coup de l'adversaire
 * @return true si this a gagn� et false si this perd
 */
public  abstract boolean  gagne(CoupShifumi  coupShifumi);



/**
 * G�re les calculs de gain si this fait un match nul contre coupShifumi, ne g�re rien dans les autres cas
 * @param coupShifumi : le coup de l'adversaire
 * @return true si le coup de l'adversaire est le m�me que this et false sinon
 */
public abstract boolean matchNull(CoupShifumi coupShifumi);
}
