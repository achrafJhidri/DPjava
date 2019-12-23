package temps;

import tools.Sujet;

public class Présent2emeGroupe extends Présent {
    public Présent2emeGroupe(){
        terminaisons.put(Sujet.JE,"is");
        terminaisons.put(Sujet.TU,"is");
        terminaisons.put(Sujet.IL,"it");
        terminaisons.put(Sujet.ELLE,"it");
        terminaisons.put(Sujet.NOUS,"issons");
        terminaisons.put(Sujet.VOUS,"issez");
        terminaisons.put(Sujet.ILS,"issent");
        terminaisons.put(Sujet.ELLES,"issent");
    }
}
