package jhidri.operations;

public class Oppose extends OperateurUnaire {
    @Override
    public double evaluer(double param) {
        return -param;
    }

    @Override
    public String toString() {
        return "-";
    }
}
