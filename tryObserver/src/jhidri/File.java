package jhidri;

import java.io.*;

public class File implements Observateur {
    private FileOutputStream file ;

    public File (String fileName) throws IOException {
        if (fileName == null ||fileName.trim().isEmpty())
            throw new IllegalArgumentException("empty file name");
        java.io.File racine = new java.io.File("");
        String absolutePathFileName = racine.getAbsolutePath()+java.io.File.separatorChar+"docs"+ java.io.File.separatorChar+fileName;
        file = new FileOutputStream(absolutePathFileName);
    }
    public void close() throws IOException {
        file.close();
    }
    @Override
    public void update(Observu observable, Object o)  {
        if ( !(o instanceof  Femme ) )
            return ;

        Femme personne = (Femme) o;
        if(1900  <= personne.getAnneeNaissance() && personne.getAnneeNaissance() <= 1999 ) {
            try {
                String newline = personne.toString() + "\n";

                file.write(newline.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
