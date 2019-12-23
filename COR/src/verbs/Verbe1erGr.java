package verbs;

import temps.Terminaison;
import tools.GroupVerbException;
import tools.Sujet;

public class Verbe1erGr extends Verbe {
    public Verbe1erGr(String verbe) throws GroupVerbException {
        super(verbe,"er");

    }
    protected Verbe1erGr(String verbe, String terminaison) throws GroupVerbException {
        super(verbe,terminaison);

    }



    @Override
    public String conjugue1èrePersonneSingulier() {
        return conjugueAuPrésent(Sujet.JE,Terminaison.PRÉSENT_1_ER_GROUPE.getTerminaison(Sujet.JE));
    }

    @Override
    public String conjugue1èrePersonnePluriel() {
        return conjugueAuPrésent(Sujet.NOUS,Terminaison.PRÉSENT_1_ER_GROUPE.getTerminaison(Sujet.NOUS));
    }



    @Override
    public String conjugueParticipePrésent() {
        return super.conjugueParticipePrésent(Terminaison.PARTICIPE_PRÉSENT_1_ER_GROUPE.getTerminaison());
    }

    @Override
    public String conjugueParticipePassé() {

        return super.conjugueParticipePassé(Terminaison.PARTICIPE_PASSÉ_1_ER_GROUPE.getTerminaison());
    }



}
