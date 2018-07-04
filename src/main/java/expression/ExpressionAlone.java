package expression;

public class ExpressionAlone implements Expression{

    double value;

    public ExpressionAlone(double value){
        this.value = value;

    }

    public double calculate() {
        return value;
    }
}
