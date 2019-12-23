package jhidri.operations;

public class Division extends OperateurBinaire  {
    public static final double EPSYLON = 0.00000000001;

    @Override
    public double evaluer(double operandeG, double operandeD) {
        if (operandeD - 0 < EPSYLON)
            throw new ArithmeticException("division par 0");
        return operandeG/operandeD;
    }
    @Override
    public String toString() {
        return "/";
    }
}
