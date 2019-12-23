package cor;

import tools.GroupVerbException;
import verbs.Verbe;
import verbs.Verbe1erGr;
import verbs.Verbe1erGrCer;

public class Createur1erGroupeCer extends CreateurExpert {
    public Createur1erGroupeCer(CreateurExpert next) {
        super(next);
    }

    @Override
    protected Verbe parse2(String v)  {
        return new Verbe1erGrCer(v);
    }
}
