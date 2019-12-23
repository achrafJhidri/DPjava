package cor;

import tools.GroupeInvalideException;
import verbs.Verbe;
import verbs.Verbe1erGr;
import tools.GroupVerbException;

public class Createur1erGroupeEr extends CreateurExpert {
    public Createur1erGroupeEr(CreateurExpert next) {
        super(next);
    }

    @Override
    protected Verbe parse2(String v)  {
        return new Verbe1erGr(v);
    }
}
