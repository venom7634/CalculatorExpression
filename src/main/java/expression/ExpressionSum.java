package expression;

public class ExpressionSum implements Expression {

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionSum(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }


    public double calculate() {
        return firstParameter.calculate()+secondParameter.calculate();
    }
}
