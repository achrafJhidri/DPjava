package jhidri;

public class Femme extends Personne {
    public Femme(String prenom, int birthdate) {
        super(prenom, birthdate);
    }
    public Femme(String infos){super(infos);}
    @Override
    public String getSexe() {
        return "Femme";
    }

    @Override
    public String toString() {
        return super.toString()+" femme";
    }

    public abstract static class Personne {

        protected String prenom;
        protected int birthdate;

        public Personne(String prenom,int birthdate){
            if ( prenom == null || prenom.trim().isEmpty() )
                throw new IllegalArgumentException("invalide "+prenom);

            this.prenom = prenom ;
            this.birthdate = birthdate;
        }

        public Personne(String chaine){
            if(chaine ==null ||chaine.trim().isEmpty())
                throw new IllegalArgumentException("chaine invalide");

            String[] infos = chaine.split(",");
            prenom=infos[0];
            birthdate=Integer.parseInt(infos[1].trim());
        }

        public String getPrenom() {
            return prenom;
        }

        public abstract String  getSexe();
        public int getAnneeNaissance(){
            return birthdate;
        }
        @Override
        public String toString() {
             return  prenom+", année de naissance :"+birthdate+", sexe :" + getSexe();
        }
    }
}
