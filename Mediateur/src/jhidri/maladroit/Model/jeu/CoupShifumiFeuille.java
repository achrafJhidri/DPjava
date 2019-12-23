package jhidri.maladroit.Model.jeu;



public class CoupShifumiFeuille extends CoupShifumi
{

public CoupShifumiFeuille(String pseudoJoueur, double miseJouee, Mediateur mediateur)
{
super(pseudoJoueur, miseJouee, mediateur);
}


/**
 * La feuille gagne contre la pierre
 * 
 * le vainqueur rafle la moiti� de la mise du perdant
 * 
 * */
@Override public boolean gagne(CoupShifumi  coupShifumi)
{



return mediateur.gagne(this,coupShifumi);
}

/**
 * En cas de match null, c'est-�-dire feuille contre feuille, la banque rafle la moiti� de la mise des deux joueurs
 * 
 * */
@Override public boolean matchNull(CoupShifumi coupShifumi)
{

return mediateur.gagne(this,coupShifumi);
}

}




