import java.util.Vector;

public class Videotheque
{
    private Vector<DVD> listeDVD = new Vector<DVD>();
    private Vector<Client> listeClients = new Vector<Client>();;

    public Videotheque()
    {

    }

    public boolean addClient(String nomClient)
    {
        return listeClients.add(new Client(nomClient,this));
    }
    /**
     * @param arg0
     * @return
     * @see java.util.Vector#get(int)
     */
    public Client getClient(int arg0) throws IllegalArgumentException {

        if ( arg0 < 0 ||arg0 >= listeClients.size()  )
            throw new IllegalArgumentException(" out of bounds Exceptions");
        return listeClients.get(arg0);
    }
    /**
     * @return
     * @see java.util.Vector#size()
     */
    public int sizeClient()
    {
        return listeClients.size();
    }


    public int indexOfClient(String nomClient)
    {
      for(Client client : listeClients) {
          if (client.getNom() == nomClient)
              return listeClients.indexOf(client);
      }
      return -1 ;
    }

    public boolean addDVD(String titre)
    {
        if(titre == null || titre.isEmpty())
            return false ;
        for(DVD dvd : listeDVD ){
            if (dvd.getNom() == titre )
                return false ;
        }
        return listeDVD.add(new DVD(titre));
    }
    /**
     * @param index
     * @return
     * @see java.util.Vector#get(int)
     */
    public DVD getDVD(int index) throws IllegalArgumentException
    {
        if ( index < 0 ||index >= listeClients.size()  )
           throw new IllegalArgumentException(" out of bounds Exceptions");
        return listeDVD.get(index);
    }

    /**
     * @return
     * @see java.util.Vector#size()
     */
    public int sizeDVD()
    {
        return listeDVD.size();
    }

    public int indexOfDVD(String titre)
    {
        for(DVD dvd : listeDVD) {
            if (dvd.getNom() == titre)
                return listeDVD.indexOf(dvd);
        }
        return -1 ;
    }
    public Vector<DVD> getDVDEmprunté(Client c){
    if ( c == null )
        throw new NullPointerException("invalid Client");

    Vector<DVD> emprunts = new Vector<DVD>();

    for(DVD dvd : listeDVD){
        if(dvd.estEmpruntéPar() == c ){
            emprunts.add(dvd);
        }
    }

    return  emprunts;

}

    public boolean vérifieReservations(Client client) {
        for(DVD dvd : listeDVD)
        {
            if (dvd.estRéservé() == client )
                return true ;
        }
        return false ;

    }

    public void annuleReservation(Client client) {
        for(DVD dvd : listeDVD){
            if (dvd.estRéservé() == client)
                dvd.annuleReservation();
        }
    }

    public void clean() {
        listeClients.clear();
        listeDVD.clear();
    }
}
