public class Article
{

    protected String nom;

    public Article(String name){
        this.nom = name ;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if ( nom.isEmpty() || nom == null )
            throw new IllegalArgumentException("invalid name ");
        this.nom = nom;
    }


    @Override
    public boolean equals(Object arg0) {
        if (arg0 == null)
            return false ;
        if (this == arg0)
            return true ;
        if (arg0 instanceof  Article){
            Article other = (Article) arg0;
            if (!other.nom.equals(this.nom))
                return false ;
            return true ;
        }
        else
            return false ;
    }

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString(){return nom;}

}
