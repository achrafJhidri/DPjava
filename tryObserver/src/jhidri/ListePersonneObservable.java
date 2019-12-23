package jhidri;


import java.util.ArrayList;
import java.util.List;


public class ListePersonneObservable extends Observu implements Observateur {
    List<Personne> personnes = new ArrayList<Personne>();


    public void add(Personne p ){
        personnes.add(p);
         notify(p);
    }

    @Override
    public String toString() {
        return personnes.toString();
    }

    @Override
    public void update(Observu o, Object obj) {
        if( obj instanceof Personne){
            Personne p = (Personne) obj;
            personnes.add(p);
        }
    }
}
