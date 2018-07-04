import expression.Expression;
import org.junit.Test;
import parser.ParserExpression;


public class ParserTest {

    @Test
    public void testParseExpression(){
        String expression = "5+6+1-42+5-21+6";
        Expression ex =ParserExpression.parseExpression(expression);

        expression = "156";
        ex = ParserExpression.parseExpression(expression);
    }

    @Test
    public void testParseExpressionDoubleSign(){
        String expression = "242++21";
        Expression ex = ParserExpression.parseExpression(expression);
    }

    @Test
    public void testParseExpressionExcessSign(){
        String expression = "51+8651+";
        Expression ex = ParserExpression.parseExpression(expression);
    }
}
