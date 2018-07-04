package expression;

public class ExpressionMul implements Expression {

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionMul(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public double calculate() {
        return firstParameter.calculate()*secondParameter.calculate();
    }
}
