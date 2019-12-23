package jhidri.maladroit.Model.jeu;

import jhidri.maladroit.Model.Banque;

public class Mediateur {
    public Banque banque ;

    public Mediateur(Banque banque ){
        this.banque=banque;
    }

    public boolean gagne(CoupShifumiPierre a,CoupShifumi b){
        if(!(b instanceof CoupShifumiCiseaux))
        return false ;
        a.miseJouee+=b.miseJouee;b.miseJouee=0;
        return true ;
    }


    public boolean matchNull(CoupShifumiPierre a, CoupShifumi b) {
        if( !(b instanceof CoupShifumiPierre)) return false;
        banque.montant += a.miseJouee+b.miseJouee;
        a.miseJouee=b.miseJouee=0;
        return true ;
    }

    public boolean gagne(CoupShifumiCiseaux a,CoupShifumi b){
        if ( !( b instanceof CoupShifumiFeuille) ) return false;

        double perteCoupShifumi = b.miseJouee*0.5;
        double perteBanque = 0.1*banque.montant;
        a.miseJouee += perteCoupShifumi + perteBanque;

        b.miseJouee -= perteCoupShifumi;
        this.banque.montant -= perteBanque;

        return true;
    }
    public boolean matchNull(CoupShifumiCiseaux a, CoupShifumi b) {
        if (!(b instanceof CoupShifumiCiseaux)) return false;

        double prise = Math.min(a.miseJouee, b.miseJouee);
        double gainBanque = 2 * prise;

        this.banque.montant += gainBanque;
        a.miseJouee -= prise;
        b.miseJouee -= prise;

        return true;
    }

    public boolean gagne(CoupShifumiFeuille a,CoupShifumi b){
        if(!(b instanceof CoupShifumiPierre) && !(b instanceof CoupShifumiPuit))
            return false;
        double gain = b.miseJouee/2;
        a.miseJouee += gain;

        b.miseJouee -= gain;

        return true;
    }


    public boolean matchNull(CoupShifumiFeuille a, CoupShifumi b) {
        if( !(b instanceof CoupShifumiFeuille)) return false;
        double montantJoue = a.miseJouee + b.miseJouee;
        double gainBanque = montantJoue/2;
        this.banque.montant += gainBanque;

        a.miseJouee*=0.5;
        b.miseJouee *= 0.5;

        return true;
    }




    public boolean gagne(CoupShifumiPuit a,CoupShifumi b){
        if(!(b instanceof CoupShifumiCiseaux) && !(b instanceof CoupShifumiPierre))
            return false;
        double gain = b.miseJouee/2;
        a.miseJouee += gain;

        b.miseJouee -= gain;

        return true;
    }


    public boolean matchNull(CoupShifumiPuit a, CoupShifumi b) {
        if( !(b instanceof CoupShifumiPuit)) return false;
        double montantJoue = a.miseJouee + b.miseJouee;
        double gainBanque = montantJoue/2;
        this.banque.montant += gainBanque;

        a.miseJouee*=0.5;
        b.miseJouee *= 0.5;

        return true;
    }































}