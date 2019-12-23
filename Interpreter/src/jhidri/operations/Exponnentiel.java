package jhidri.operations;
import static java.lang.Math.*;
public class Exponnentiel extends OperateurUnaire {
    @Override
    public double evaluer(double param) {
        return exp(param);
    }

    @Override
    public String toString() {
        return "exp";
    }
}
