package expression;

public class ExpressionPow implements Expression{

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionPow(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public double calculate() {
        return Math.pow(firstParameter.calculate(),secondParameter.calculate());
    }
}
