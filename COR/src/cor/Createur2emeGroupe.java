package cor;

import verbs.Verbe;
import verbs.Verbe2emeGr;
import tools.GroupVerbException;

public class Createur2emeGroupe extends CreateurExpert {
    public Createur2emeGroupe(CreateurExpert next) {
        super(next);
    }

    @Override
    protected Verbe parse2(String v) {

        return new Verbe2emeGr(v);
    }
}
