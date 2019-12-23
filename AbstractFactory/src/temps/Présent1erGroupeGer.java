package temps;

import tools.Sujet;

public class Présent1erGroupeGer extends Présent1erGroupe {
    public Présent1erGroupeGer(){
        terminaisons.put(Sujet.JE,"e");
        terminaisons.put(Sujet.TU,"es");
        terminaisons.put(Sujet.IL,"e");
        terminaisons.put(Sujet.ELLE,"e");
        terminaisons.put(Sujet.NOUS,"ions");
        terminaisons.put(Sujet.VOUS,"iez");
        terminaisons.put(Sujet.ILS,"ent");
        terminaisons.put(Sujet.ELLES,"ent");
    }
}
