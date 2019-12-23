public class DVD extends Article
{
    private Client réserveur=null;
    private Client emprunteur=null;

    public DVD(String nom)
    {
        super(nom);

    }

    public Client estEmpruntéPar(){return emprunteur;}

    public Client estRéservé() {return réserveur;}


    public void estEmpruntéPar(Client client) {
        isNull(client);
        emprunteur = client;
    }

    private void isNull(Client client) {
        if (client == null)
            throw new IllegalArgumentException("Client null");
    }

    public boolean estRendu(Client c ){
        if ( c == emprunteur )
        {
            emprunteur= null ;
            return true ;
        }
            return false ;
    }
    public void annuleReservation(){
        réserveur = null;
    }

    public void estRéservé(Client client) {
        isNull(client);
        réserveur = client ;
    }
}
