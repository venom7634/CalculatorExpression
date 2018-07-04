package expression;

public class ExpressionDiv implements Expression {

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionDiv(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public double calculate() {
        return firstParameter.calculate()/secondParameter.calculate();
    }
}
