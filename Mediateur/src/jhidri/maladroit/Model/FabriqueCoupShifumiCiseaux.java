package jhidri.maladroit.Model;


import jhidri.maladroit.Model.jeu.CoupShifumi;
import jhidri.maladroit.Model.jeu.CoupShifumiCiseaux;
import jhidri.maladroit.Model.jeu.Mediateur;

public class FabriqueCoupShifumiCiseaux extends FabriqueCoupShifumi
{

    public FabriqueCoupShifumiCiseaux(Mediateur m) {
        super(m);
    }

    @Override
public CoupShifumi creeCoupShifumi(String pseudoJoueur, double miseJouee,
                                   Mediateur mediateur)
{
return new CoupShifumiCiseaux(pseudoJoueur, miseJouee, mediateur);
}

@Override
public String toString()
{
return "Ciseaux";
}

}
