package jhidri.expressions;

public class Constante extends Expression {
    private double valeur ;
    public Constante(double value){
        super();
        this.valeur= value ;
    }
    @Override
    public double evaluer(double x){
        return valeur;
    }

    @Override
    public String toString() {
        return String.valueOf(valeur);
    }
}
