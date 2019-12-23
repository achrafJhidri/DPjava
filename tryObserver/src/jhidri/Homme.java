package jhidri;

public class Homme extends Personne {
    public Homme(String prenom, int birthdate) {
        super(prenom, birthdate);
    }
    public Homme(String infos){super(infos);}

    @Override
    public String getSexe() {
        return "Homme";
    }


    @Override
    public String toString(){
        return super.toString()+" masculin";
    }


}

