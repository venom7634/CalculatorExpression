package expression;

public class ExpressionRemainderOfDivision implements Expression {

    Expression firstParameter;
    Expression secondParameter;

    public ExpressionRemainderOfDivision(Expression firstParameter, Expression secondParameter){
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public double calculate() {
        return firstParameter.calculate()%secondParameter.calculate();
    }
}
