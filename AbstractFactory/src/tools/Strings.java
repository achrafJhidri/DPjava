package tools;

public enum Strings {
    CONJUGUE1EREPERSONNESINGULIER("conjugue1èrePersonneSingulier"),
    CONJUGUE1EREPERSONNEPLURIEL("conjugue1èrePersonnePluriel"),
    CONJUGUEPARTICIPEPASSE("conjugueParticipePassé"),
    CONJUGUEPARTICIPEPRESENT("conjugueParticipePrésent");

    Strings( String s){
        string = s ;
    }

    private final String string;

    @Override
    public String toString() {
        return  string;
    }
}
