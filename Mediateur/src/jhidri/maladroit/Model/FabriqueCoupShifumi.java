package jhidri.maladroit.Model;

import jhidri.maladroit.Model.jeu.CoupShifumi;
import jhidri.maladroit.Model.jeu.Mediateur;

public abstract class FabriqueCoupShifumi
{
    public Mediateur mediateur;
    public FabriqueCoupShifumi(Mediateur m){
        mediateur=m;
    }
public abstract CoupShifumi creeCoupShifumi(String pseudoJoueur, double miseJouee, Mediateur mediateur);

}
