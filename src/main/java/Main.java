import expression.Expression;
import parser.ParserExpression;

public class Main {

    public static void main(String[] args) {
        Expression ex = ParserExpression.parseExpression("5+6+7-2+7");
        double lol = ex.calculate();
        System.out.print(lol);
    }
}
