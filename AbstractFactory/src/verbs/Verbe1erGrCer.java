package verbs;

import temps.Terminaison;
import tools.GroupVerbException;
import tools.Sujet;

public class Verbe1erGrCer extends Verbe1erGr{
    public Verbe1erGrCer(String verbe) throws GroupVerbException {
        super(verbe,"cer");
    }

    @Override
    public String conjugueAuPrésent(Sujet sujet,String terminaison) {
        return super.conjugueAuPrésent(sujet, Terminaison.PRÉSENT_1_ER_GROUPE_CER.getTerminaison(sujet));
    }

    @Override
    public String conjugueParticipePrésent() {
        return getRadicalParticipePrésent()+Terminaison.PARTICIPE_PRÉSENT_1_ER_GROUPE_CER.getTerminaison();
    }

    @Override
    public String conjugueParticipePassé() {
        return getRadical()+Terminaison.PARTICIPE_PASSÉ_1_ER_GROUPE_CER.getTerminaison();
    }
}
