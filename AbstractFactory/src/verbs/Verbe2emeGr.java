package verbs;

import temps.Terminaison;
import tools.GroupVerbException;
import tools.Sujet;

public class Verbe2emeGr extends Verbe {
    public Verbe2emeGr(String verbe) throws GroupVerbException {
        super(verbe,"ir");

    }

    @Override
    public String conjugue1èrePersonneSingulier() {
        return conjugueAuPrésent(Sujet.JE, Terminaison.PRÉSENT_2_EME_GROUPE.getTerminaison(Sujet.JE));
    }

    @Override
    public String conjugue1èrePersonnePluriel() {
        return conjugueAuPrésent(Sujet.NOUS,Terminaison.PRÉSENT_2_EME_GROUPE.getTerminaison(Sujet.NOUS));
    }

    @Override
    public String conjugueParticipePrésent() {
        return super.conjugueParticipePrésent(Terminaison.PARTICIPE_PRÉSENT_2_EME_GROUPE.getTerminaison());
    }

    @Override
    public String conjugueParticipePassé() {
        return super.conjugueParticipePassé(Terminaison.PARTICIPE_PASSÉ_2_EME_GROUPE.getTerminaison());
    }
}
