package tools;

public enum Voyelle {
    A("a"),
    E("e"),
    O("o"),
    U("u"),
    I("i"),
    Y("y") ;

    Voyelle(String lettre){
        this.lettre = lettre;
    }
    private final String lettre  ;

    @Override
    public String toString() {
        return lettre ;
    }
    public static boolean isVoyelle(char c) {
        if ( c == 'a' || c== 'e' ||  c =='o' ||c == 'u' || c == 'i'||c == 'y')
                return true ;
        return false ;
    }
    public boolean Equals(Object o ){
        if(o == null )
            return false ;
        if(o == this )
            return true ;
        if ( o instanceof String  )
            return this.lettre == (String) o ;
        if( this != null && o instanceof Voyelle )
            if(this.lettre != ((Voyelle )o).lettre)
                return false ;
        return true ;
    }
}
