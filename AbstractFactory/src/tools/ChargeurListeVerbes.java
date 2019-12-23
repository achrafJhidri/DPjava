package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;
import verbs.Verbe;
import verbs.Verbe1erGr;
import verbs.Verbe2emeGr;

/**
 * responsable du chargement de listes de verbes à partir de fichiers textes
 *
 * */
public class ChargeurListeVerbes {
    /**
     * @param : f supposé être un fichier texte de la forme :
     *          <p>
     *          chanter
     *          danser
     *          travailler
     *          java
     *          jouer
     *          aboutir
     *          marcher
     *          <p>
     *          C'est-à-dire que f contient un verbe du 1er groupe par ligne.
     *          Chaque ligne suit le format :  infinitif d'un verbe du 1er groupe
     *          La ligne peut contenir d'éventuels espaces
     *          Une ligne dont le format est inconnu ou contenant un verbe qui n'est pas du 1er groupe est ignorée
     *          f peut être vide
     * @return la liste des verbes obtenus par lecture et parcours du fichier f
     */

    public static Vector<Verbe> chargeGroupe1(BufferedReader f) {
        Vector<Verbe> liste = new Vector<Verbe>(); // création de la liste vide

        String ligneLue;        // la prochaine ligne à lire dans f

        try {
            do                              // on boucle sur les lignes du fichier : on lit le fichier ligne par ligne
            {
                ligneLue = f.readLine();    // lecture de la prochaine ligne dans le fichier


                if (ligneLue != null)   // on n'a pas atteint la fin de fichier
                    try {
                        Verbe verbe = new Verbe1erGr(ligneLue.trim());          // création du verbe correspondant à l'infinitif extrait du fichier

                        liste.add(verbe);                                           // on ajoute le nouveau verbe dans la liste
                    } catch (GroupVerbException e) {
                        // La ligne traitée ne contenait pas l'infinitif d'un verbe du 1er groupe. Cette ligne est donc ignorée.
                    }

            }
            while (ligneLue != null);    // tant que le fichier n'est pas entièrement parcouru
        } catch (IOException e) {
            // il y un pb de lecture avec le fichier f. On s'arrête là et on retourne la liste qu'on a construit jusqu'à présent
        }

        return liste;
    }
    /**
     * @param : f supposé être un fichier texte de la forme :
     *
     *      frémir
     *      atterrir
     *      vélo
     *      réfléchir
     *      permettre
     *      nourrir
     *      naviguer
     *      finir
     *
     * C'est-à-dire que f contient un verbe du 2ème groupe par ligne.
     * Chaque ligne suit le format :  infinitif d'un verbe du 2ème groupe
     * La ligne peut contenir d'éventuels espaces
     * Une ligne dont le format est inconnu ou contenant un verbe qui n'est pas du 2ème groupe est ignorée
     * f peut être vide
     *
     * @return la liste des verbes obtenus par lecture et parcours du fichier f
     * */
    public static Vector<Verbe> chargeGroupe2(BufferedReader f)
    {
        Vector<Verbe> liste = new Vector<Verbe>(); // création de la liste vide

        String ligneLue;        // la prochaine ligne à lire dans f

        try
        {
            do                              // on boucle sur les lignes du fichier : on lit le fichier ligne par ligne
            {
                ligneLue = f.readLine();    // lecture de la prochaine ligne dans le fichier


                if (ligneLue != null)   // on n'a pas atteint la fin de fichier
                    try
                    {
                        Verbe verbe = new Verbe2emeGr(ligneLue.trim());          // création du verbe correspondant à l'infinitif extrait du fichier

                        liste.add(verbe);                                           // on ajoute le nouveau verbe dans la liste
                    }
                    catch (GroupVerbException e)
                    {
                        // La ligne traitée ne contenait pas l'infinitif d'un verbe du 2ème groupe. Cette ligne est donc ignorée.
                    }

            }
            while(ligneLue != null);    // tant que le fichier n'est pas entièrement parcouru
        }
        catch (IOException e)
        {
            // il y un pb de lecture avec le fichier f. On s'arrête là et on retourne la liste qu'on a construit jusqu'à présent
        }

        return liste;
    }

}
