package verbs;

import temps.Terminaison;
import tools.GroupVerbException;
import tools.Sujet;

public class Verbe1erGrGer extends Verbe1erGr {


    public Verbe1erGrGer(String verbe) throws GroupVerbException {
        super(verbe,"ger");
        radical = verbe.substring(0,verbe.lastIndexOf("er"));
    }
    @Override
    public String conjugueParticipePrésent() {
        return conjugueParticipePrésent( Terminaison.PARTICIPE_PRÉSENT_1_ER_GROUPE_GER.getTerminaison());
    }

    @Override
    public String conjugueAuPrésent(Sujet sujet,String terminaison) {
        return super.conjugueAuPrésent(sujet,Terminaison.PRÉSENT_1_ER_GROUPE_GER.getTerminaison(sujet));
    }

}
