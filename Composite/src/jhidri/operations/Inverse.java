package jhidri.operations;

public class Inverse extends OperateurUnaire {
    @Override
    public double evaluer(double param) {
        if ( param - 0 < Division.EPSYLON)
            throw new ArithmeticException("inverse de 0 est 1/0 operation invalide");
        return 1/param;
    }
}
