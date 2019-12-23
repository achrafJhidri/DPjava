package cor;

import tools.GroupVerbException;
import verbs.Verbe;
import verbs.Verbe1erGr;
import verbs.Verbe1erGrGer;

public class Createur1erGroupeGer extends CreateurExpert {
    public Createur1erGroupeGer(CreateurExpert next) {
        super(next);
    }

    @Override
    protected Verbe parse2(String v) {
        return new Verbe1erGrGer(v);
    }
}
