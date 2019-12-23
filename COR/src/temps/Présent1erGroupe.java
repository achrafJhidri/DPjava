package temps;

import tools.Sujet;

public class Présent1erGroupe extends Présent{
    public Présent1erGroupe(){
        terminaisons.put(Sujet.JE,"e");
        terminaisons.put(Sujet.TU,"es");
        terminaisons.put(Sujet.IL,"e");
        terminaisons.put(Sujet.ELLE,"e");
        terminaisons.put(Sujet.NOUS,"ons");
        terminaisons.put(Sujet.VOUS,"ez");
        terminaisons.put(Sujet.ILS,"ent");
        terminaisons.put(Sujet.ELLES,"ent");
    }
}
