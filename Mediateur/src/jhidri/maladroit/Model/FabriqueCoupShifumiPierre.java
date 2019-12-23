package jhidri.maladroit.Model;


import jhidri.maladroit.Model.jeu.CoupShifumi;
import jhidri.maladroit.Model.jeu.CoupShifumiPierre;
import jhidri.maladroit.Model.jeu.Mediateur;

public class FabriqueCoupShifumiPierre extends FabriqueCoupShifumi
{

    public FabriqueCoupShifumiPierre(Mediateur m) {
        super(m);
    }

    @Override
public CoupShifumi creeCoupShifumi(String pseudoJoueur, double miseJouee, Mediateur mediateur)
{
return new CoupShifumiPierre(pseudoJoueur, miseJouee, mediateur);
}

@Override
public String toString()
{
return "Pierre";
}


}
