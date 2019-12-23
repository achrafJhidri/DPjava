package tools;

public enum Sujet {
    JE("Je"),
    TU("Tu"),
    IL("il"),
    ELLE("elle"),
    NOUS("nous"),
    VOUS("vous"),
    ILS("ils"),
    ELLES("elles");

    Sujet(String s ){
        this.sujet = s ;
    }

    private final String sujet ;

    @Override
    public String toString() {
        return sujet;
    }
}
