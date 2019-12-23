package jhidri.maladroit.Model;

import jhidri.maladroit.Model.jeu.CoupShifumi;
import jhidri.maladroit.Model.jeu.CoupShifumiFeuille;
import jhidri.maladroit.Model.jeu.Mediateur;

public class FabriqueCoupShifumiFeuille extends FabriqueCoupShifumi
{

    public FabriqueCoupShifumiFeuille(Mediateur m) {
        super(m);
    }

    @Override
public CoupShifumi creeCoupShifumi(String pseudoJoueur, double miseJouee,
                                   Mediateur mediateur)
{
return new CoupShifumiFeuille(pseudoJoueur, miseJouee, mediateur);
}

@Override
public String toString()
{
return "Feuille";
}

}
