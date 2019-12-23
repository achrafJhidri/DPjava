package jhidri.operations;

public class Fois extends OperateurBinaire  {


    @Override
    public double evaluer(double operandeG, double operandeD) {
        return operandeG*operandeD;
    }
    @Override
    public String toString() {
        return "*";
    }
}
