package temps;

public abstract class Statique implements Terminaison {
    protected  Statique (String terminaison ){
        if ( terminaison == null || terminaison.trim().isEmpty()){
            throw new IllegalArgumentException("terminaison nul ou vide ");
        }
        this.terminaison=terminaison;
    }
    protected String terminaison = null ;
    public String getTerminaison(){
        return terminaison;
    };
}
