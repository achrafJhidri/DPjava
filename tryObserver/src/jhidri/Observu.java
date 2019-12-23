package jhidri;

import java.util.ArrayList;
import java.util.List;
//obsevable
public class Observu {
    List<Observateur> observateurs = new ArrayList<Observateur>();


    public void notify(Object o ){
        for(Observateur observateur : observateurs){
            observateur.update(this,o);
        }
    }


    public boolean addObservateur(Observateur observateur) {
        return observateurs.add(observateur);
    }
}
