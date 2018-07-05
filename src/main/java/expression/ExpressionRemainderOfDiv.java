package expression;

public class ExpressionRemainderOfDiv implements Expression {

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionRemainderOfDiv(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public double calculate() {
        return firstParameter.calculate()%secondParameter.calculate();
    }
}
