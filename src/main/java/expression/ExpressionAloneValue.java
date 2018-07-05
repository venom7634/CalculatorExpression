package expression;

public class ExpressionAloneValue implements Expression{

    double value;

    public ExpressionAloneValue(double value){
        this.value = value;

    }

    public double calculate() {
        return value;
    }
}
