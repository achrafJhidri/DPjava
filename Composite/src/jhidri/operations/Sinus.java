package jhidri.operations;
import static java.lang.Math.*;

public class Sinus extends OperateurUnaire {
    @Override
    public double evaluer(double param) {
        return sin(param);
    }

    @Override
    public String toString() {
        return "Sin";
    }
}
