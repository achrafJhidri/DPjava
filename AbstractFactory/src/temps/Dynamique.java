package temps;

import tools.Sujet;

import java.util.HashMap;


public abstract class Dynamique implements Terminaison {

    protected HashMap<Sujet,String> terminaisons = new HashMap<>(8) ;

    public  String getTerminaison(Sujet sujet){
       return terminaisons.get(sujet);
    };
}
