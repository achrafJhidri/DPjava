import factory.Verbe1erGrCreator;
import factory.VerbeFactory;
import tools.ChargeurListeVerbes;
import verbs.Verbe;
import verbs.Verbe1erGr;
import verbs.Verbe2emeGr;

import java.io.*;
import java.util.Vector;

public class Main {

    public static void main(String[] args)
    {

        try
        {
            System.out.println("Exo sur les fabriques de verbes. Version sans les fabriques : doit être améliorée");
            File chemin = new File("");             // racine du projet : endroit d'où est lancée la JVM
            System.out.println("chemin relatif = " + chemin);
            System.out.println("chemin absolu= " + chemin.getAbsolutePath());

            File cheminDonnées = new File(chemin.getAbsoluteFile(), "data" ); // chemin du répertoire des données
            System.out.println("cheminDonnées = " + cheminDonnées.getAbsolutePath());

            File cheminG1 = new File(cheminDonnées.getAbsoluteFile(),"verbes1erGroupe.txt");

            BufferedReader f1 = new BufferedReader( new InputStreamReader( new FileInputStream(cheminG1.getAbsolutePath())));  // on ouvre le fichier de données en lecture de texte

            Vector<Verbe> liste1 = VerbeFactory.charge(f1,new Verbe1erGrCreator()); // on charge la liste de verbes du 1er groupe

            System.out.println("\n"+"liste1 = " + liste1);


        }
        catch (FileNotFoundException e)
        {

            System.err.println("échec du chargement d'un fichier de données");
        }

    }

}
