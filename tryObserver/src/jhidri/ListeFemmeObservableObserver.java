package jhidri;

import jhidri.Femme;
import jhidri.Observateur;
import jhidri.Observu;

import java.util.ArrayList;

public class ListeFemmeObservableObserver extends Observu implements Observateur {

    private ArrayList<Femme> femmes = new ArrayList<Femme>();
    @Override
    public void update(Observu observable, Object o) {


    }

    private void add(Femme f){
        femmes.add(f);
        notify(f);
    }

    @Override
    public String toString() {
        return femmes.toString();
    }


}
