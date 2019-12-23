package factory;

import verbs.Verbe;
import verbs.Verbe2emeGr;

public class Verbe2emeGrCreator implements VerbeCreator {
    @Override
    public Verbe createVerbe(String infinitif) {
        return new Verbe2emeGr(infinitif);
    }
}
