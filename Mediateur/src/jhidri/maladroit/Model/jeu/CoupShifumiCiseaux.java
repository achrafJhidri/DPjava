package jhidri.maladroit.Model.jeu;


import jhidri.maladroit.Model.Banque;

public class CoupShifumiCiseaux extends CoupShifumi
{

public CoupShifumiCiseaux(String pseudoJoueur, double miseJouee,Mediateur m)
{
super(pseudoJoueur, miseJouee,m);
}

/**
 * Les ciseaux gagnent contre la feuille
 * 
 * le vainqueur rafle la moiti� de la mise du perdant et re�oit en plus un cadeau de la banque qui s'�l�ve � 10% du montant de la banque
 * 
 * */
@Override public boolean gagne(CoupShifumi  coupShifumi)
{

return mediateur.gagne(this,coupShifumi);
}

/**
 * En cas de match null, c'est-�-dire ciseaux contre ciseaux, la banque prend � chaque  joueur la somme �quivalente � la mise la plus petite
 * 
 * */
@Override public boolean matchNull(CoupShifumi coupShifumi)
{

return mediateur.matchNull(this,coupShifumi);
}

}


