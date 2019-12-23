package temps;

import tools.Sujet;

public class Présent1erGroupeCer extends Présent1erGroupe {
    public Présent1erGroupeCer(){
        terminaisons.put(Sujet.JE,"ce");
        terminaisons.put(Sujet.TU,"ces");
        terminaisons.put(Sujet.IL,"ce");
        terminaisons.put(Sujet.ELLE,"ce");
        terminaisons.put(Sujet.NOUS,"çons");
        terminaisons.put(Sujet.VOUS,"cez");
        terminaisons.put(Sujet.ILS,"cent");
        terminaisons.put(Sujet.ELLES,"cent");
    }
}
