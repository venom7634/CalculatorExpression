import expression.Expression;
import parser.ParserExpression;

public class Main {

    public static void main(String[] args) {
        Expression ex = ParserExpression.parseExpression("5+6+7-2+7");
        double result = ex.calculate();
        System.out.print(result);
    }
}
