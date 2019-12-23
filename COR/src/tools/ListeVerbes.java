package tools;

import tools.Strings;
import verbs.Verbe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

public class ListeVerbes {
    private ArrayList<Verbe> verbes = null;
    public ListeVerbes( int size){
        verbes = new ArrayList<Verbe>(size);
    };

    public boolean add(Collection<Verbe> verbs){
        if (verbs == null )
            throw new IllegalArgumentException("Invalid Array");


       return verbes.addAll(verbs);
    }

    public void conjuger(Strings methode) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> verbesConjugés = new ArrayList<String>(verbes.size());
        for(Verbe verbe : verbes ) {
            System.out.println();
            Method m = Verbe.class.getMethod(methode.toString());
            String v = (String) m.invoke(verbe);
            verbesConjugés.add(v);
            System.out.println(v);
        }

    }
}
