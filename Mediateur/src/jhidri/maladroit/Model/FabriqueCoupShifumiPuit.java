package jhidri.maladroit.Model;

import jhidri.maladroit.Model.jeu.CoupShifumi;
import jhidri.maladroit.Model.jeu.CoupShifumiPuit;
import jhidri.maladroit.Model.jeu.Mediateur;

public class FabriqueCoupShifumiPuit extends FabriqueCoupShifumi  {
    public FabriqueCoupShifumiPuit(Mediateur m) {
        super(m);
    }

    @Override
    public CoupShifumi creeCoupShifumi(String pseudoJoueur, double miseJouee, Mediateur mediateur) {
        return new CoupShifumiPuit(pseudoJoueur,miseJouee,mediateur);
    }

    @Override
    public String toString()
    {
        return "Puit";
    }

}
