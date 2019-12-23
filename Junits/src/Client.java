import java.util.Vector;

public class Client extends Article
{
    private Videotheque videotheque ;
    private boolean aFaitUneRéservation = false ;

    public Client(String nomClient, Videotheque videothèque)
    {
        super(nomClient);
        this.videotheque = videothèque ;
    }

    public boolean emprunte(DVD dVD)
    {
            if(dVD.estEmpruntéPar() == null)
                {
                    if (dVD.estRéservé() == this)
                    {
                        dVD.annuleReservation();
                        dVD.estEmpruntéPar(this);
                        return true;
                    }else if(dVD.estRéservé() == null ) {
                        dVD.estEmpruntéPar(this);
                        return true;
                    }
                }

        return  false;
    }

    public Vector<DVD> listeEmprunts()
    {
        return videotheque.getDVDEmprunté(this);
    }

    public boolean rend(DVD dVD)
    {
        return dVD.estRendu(this);
    }

    public void réserve(DVD dVD){
        if ( !videotheque.vérifieReservations(this) )
            if ( dVD.estRéservé() == null );
                   dVD.estRéservé(this) ;

    }

    public void annuleRéservation(){
        videotheque.annuleReservation(this);

    }



}
