import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class main {

    public static void main(String[] args) {
        try {
           /* File racine = new File(""); // contient le chemin d'où est lancée la JVM
            File ici = new File(racine.getAbsoluteFile(),"docs");
            String nomFichier1 = ici.getAbsolutePath()+File.separatorChar+ "mapersonne1.txt";
            Object obj1 = ParseurClasse.parse(nomFichier1);

            System.out.println("1er objet instancié = " + obj1);

            String nomFichier2 = ici.getAbsolutePath()+File.separatorChar+ "moncercle1.txt";

            Object obj2 = ParseurClasse.parse(nomFichier2);

            System.out.println("2ème objet instancié = " + obj2);

            String nomFichier3 = ici.getAbsolutePath()+File.separatorChar+ "moncercle2.txt";

            Object obj3 = ParseurClasse.parse(nomFichier3);   // contient un appel
            // récursif

            System.out.println("3ème objet instancié = " + obj3);*/
            SauveurClasse.sauve(new Cercle(new Point(-23.7,41.2),12.5), "moncercle1C");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       /* catch (SecurityException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }*/
    }
}
