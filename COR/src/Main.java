import cor.*;
import tools.GroupeInvalideException;
import verbs.Verbe;
import tools.GroupVerbException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static CreateurExpert cor = buildCOR() ;
    public static void main(String[] args)   {

        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Veuillez saisir le verbe a conjuger :\n");
            String line =  buffer.readLine();

            Verbe v = null;
            while (!line.equals("Q")) {

                if ( !line.trim().isEmpty() ){
                    try {
                        v = cor.parse(line);

                        String conjugaisonTotale = "";
                        conjugaisonTotale += v.conjugue1èrePersonneSingulier() + "\n";
                        conjugaisonTotale += v.conjugue1èrePersonnePluriel() + "\n";

                        conjugaisonTotale += v.conjugueParticipePassé() + "\n";
                        conjugaisonTotale += v.conjugueParticipePrésent() + "\n";

                        System.out.println(conjugaisonTotale);
                    } catch (GroupeInvalideException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(line);
                    System.out.println("\n\nVeuillez saisir le verbe a conjuger :\n");
                    line = buffer.readLine();
                }
            }
        }catch (IOException io){
            System.out.println(io.getMessage());
        }

    }



    private static CreateurExpert buildCOR(){







        cor=null;
        cor = new Createur2emeGroupe(cor);
        cor = new Createur1erGroupeEr(cor);
        cor = new Createur1erGroupeGer(cor);
        cor = new Createur1erGroupeCer(cor);
        return cor ;
    }
}
