package jhidri.expressions;

import jhidri.operations.Operateur;

public abstract class ExpressionComplexe extends Expression {


    protected  ExpressionComplexe(Operateur op){
        super();
        if(op == null )
            throw new IllegalArgumentException("Operateur null");
    }


}
