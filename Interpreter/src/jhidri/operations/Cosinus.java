package jhidri.operations;
import static java.lang.Math.*;

public class Cosinus extends OperateurUnaire {
    @Override
    public double evaluer(double param) {
        return cos(param);
    }

    @Override
    public String toString() {
        return "Cos";
    }
}
