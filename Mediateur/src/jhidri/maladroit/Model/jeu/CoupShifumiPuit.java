package jhidri.maladroit.Model.jeu;

import jhidri.maladroit.Model.Banque;

public class CoupShifumiPuit extends CoupShifumi {
    public CoupShifumiPuit(String pseudoJoueur, double miseJouee, Mediateur mediateur) {
        super(pseudoJoueur, miseJouee, mediateur);
    }

    @Override
    public boolean gagne(CoupShifumi coupShifumi) {
        return mediateur.gagne(this,coupShifumi);
    }

    @Override
    public boolean matchNull(CoupShifumi coupShifumi) {
        return mediateur.matchNull(this,coupShifumi);
    }

}
