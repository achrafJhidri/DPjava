package jhidri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        maFrame frame = new maFrame("personne agée",50,50);
        try {
            File file= new File("fichier1.txt");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String l ;
            ListeFemmeObservableObserver listeFemmes=new ListeFemmeObservableObserver();
            ListePersonneObservable listePersonnes = new ListePersonneObservable();

            listePersonnes.addObservateur(frame);
            listePersonnes.addObservateur(file);
            listePersonnes.addObservateur(listeFemmes);

            listeFemmes.addObservateur(listePersonnes);
            listeFemmes.addObservateur(file);
            listeFemmes.addObservateur(frame);

            do{
                System.out.println("Les personnes");
                System.out.println(listePersonnes);
                System.out.println("Les femmes");
                System.out.println(listeFemmes);
                frame.setVisible(true);
                System.out.println("H pour Homme, F pour femme, Q pour quitter :\n");
                l=buffer.readLine();
                Personne p = null;
                if(l.equals("Q"))
                    break ;
                else if(l.equals("H"))
                {
                    l= buffer.readLine();
                    p = new Homme(l);

                }else if(l.equals("F"))
                {
                    l= buffer.readLine();
                    p=new Femme(l);
                }
                else
                    continue;
                listePersonnes.add(p);


            }while(l!=null);

            file.close();


        }catch(IOException e){
            e.printStackTrace();
        }
        frame.dispose();
    }

}
