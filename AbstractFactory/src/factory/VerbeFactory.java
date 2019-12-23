package factory;

import tools.GroupVerbException;
import verbs.Verbe;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

public  abstract class VerbeFactory {


    public static  Vector<Verbe>  charge(BufferedReader buffer,VerbeCreator vCreator ){
        Vector<Verbe> vector = new Vector<Verbe>();
        String ligneLue;

        try{

            do {
                ligneLue = buffer.readLine();
                if (ligneLue != null) {
                    try {
                        Verbe v = vCreator.createVerbe(ligneLue.trim());
                        vector.add(v);
                    } catch (GroupVerbException e) {
                        e.printStackTrace();
                    }
                }
            }while(ligneLue !=null);

        }catch(IOException e){
            e.printStackTrace();
        }
        return vector;
    }

}
