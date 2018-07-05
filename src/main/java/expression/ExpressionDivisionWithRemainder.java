package expression;

public class ExpressionDivisionWithRemainder implements Expression {

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionDivisionWithRemainder(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public double calculate() {
        return firstParameter.calculate()%secondParameter.calculate();
    }
}
