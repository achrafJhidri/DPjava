package verbs;

import temps.Terminaison;
import tools.GroupVerbException;
import tools.Sujet;
import tools.Voyelle;

public abstract class Verbe {

    protected String radical = null ;

    protected Verbe(String infinitif,String terminaison )  {
        if(infinitif == null  || infinitif.trim().isEmpty())
            throw new IllegalArgumentException("Invalid Verbe");
        if ( !Verbe.endsWith(infinitif,terminaison))
            throw new GroupVerbException(infinitif+" ne se termine pas avec "+terminaison+".");

        radical=infinitif.substring(0,infinitif.lastIndexOf(terminaison));



    }

    public  String conjugueAuPrésent(Sujet sujet,String terminaison){
        return getRadicalAvecSujet(sujet)+terminaison;
    };

    public static boolean endsWith(String origine ,String suffix){
        boolean b ;
        b=  origine.endsWith(suffix);
        return b ;
    };

    public String getRadicalAvecSujet(Sujet sujet ){
        if ( Voyelle.isVoyelle(radical.charAt(0))  && (sujet == Sujet.JE || sujet == Sujet.TU) )
            return sujet.toString().charAt(0)+"'"+getRadical();
        else
            return sujet+" "+getRadical();
    };

    public  String getRadical(){
        return radical;
    }

    protected String getRadicalParticipePrésent(){
        return "En "+getRadical();
    }



    public abstract String conjugue1èrePersonneSingulier() ;
    public abstract String conjugue1èrePersonnePluriel();



    public abstract String conjugueParticipePrésent();
    public String conjugueParticipePrésent( String terminaison ){
        return getRadicalParticipePrésent()+terminaison;
    }



    public abstract String conjugueParticipePassé();
    public          String conjugueParticipePassé(String terminaison){
        return getRadical()+terminaison;
    };


}
