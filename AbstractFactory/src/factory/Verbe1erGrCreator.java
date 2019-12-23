package factory;

import verbs.Verbe;
import verbs.Verbe1erGr;

public class Verbe1erGrCreator implements VerbeCreator{

    @Override
    public Verbe createVerbe(String infinitif) {
        return new Verbe1erGr(infinitif);
    }
}
