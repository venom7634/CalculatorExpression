package expression;

public class ExpressionSub implements Expression {

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionSub(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public double calculate() {
        return firstParameter.calculate()-secondParameter.calculate();
    }
}
