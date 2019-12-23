package jhidri.operations;

public class Soustraction extends OperateurBinaire  {


    @Override
    public double evaluer(double operandeG, double operandeD) {
        return operandeG-operandeD;
    }


    @Override
    public String toString() {
        return "-";
    }
}
